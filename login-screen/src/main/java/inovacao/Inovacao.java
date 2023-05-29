/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inovacao;

import com.github.britooo.looca.api.core.Looca;
import models.Componente;
import sql.Conection;
import app.InfoPc;
import app.InserirMetrica;
import models.Metrica;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import models.HistoricoReiniciar;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author faculdade
 */
public class Inovacao {

    private Looca looca;

    public Inovacao() {
        this.looca = new Looca();
    }

    public Integer fkEmpresa() {
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();
        InfoPc infoPc = new InfoPc();

        String hostname = infoPc.hostName();

        return con.queryForObject("select fkEmpresa from Computador where hostname = ?", Integer.class, hostname);
    }

    public Integer valorParametro() {
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();

        return con.queryForObject("select valor from Parametros where fkAlerta = 1 and fkEmpresa = ? and fkComponente = 2", Integer.class, fkEmpresa());
    }

    public Boolean verificarRam() {
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();
        InserirMetrica im = new InserirMetrica();

        List<Metrica> metrica = con.query("select top 18 * from Metrica where fkConfig = ? order by dtCaptura desc ;",
                new BeanPropertyRowMapper(Metrica.class), im.fkConfigRam());

        Boolean response = false;

        for (Metrica met : metrica) {
            if (met.getValor() > valorParametro()) {
                response = true;
            } else {
                response = false;
            }
        }
        return response;
    }

    public Boolean verificarData() {
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();
        InfoPc infoPc = new InfoPc();

        String hostname = infoPc.hostName();

        Boolean response = false;

        List<HistoricoReiniciar> hr = con.query("SELECT * from [dbo].[historicoReiniciar]"
                + " where cast(dtCaptura as date) = CAST(CURRENT_TIMESTAMP as DATE) and fkComputador = ?;",
                new BeanPropertyRowMapper(HistoricoReiniciar.class), hostname);

        Integer temp = 0;
        for (HistoricoReiniciar hR : hr) {
            temp = hR.getTempoReiniciar();
        }

        if (hr.size() < 1 && verificarRam()) {
            con.update("insert into [dbo].[historicoReiniciar]"
                    + "(tempoReiniciar,dtCaptura,fkComputador) "
                    + "values (5, CURRENT_TIMESTAMP, ?);", hostname);

            response = true;
        }

        if (hr.size() > 0 && temp >= 5) {
            response = true;
        }

        return response;
    }

    public void reiniciar() throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        String resposta;
        if (verificarData() && verificarRam()) {
            System.out.println("Reiniciar o computador agora ?");
            resposta = scan.nextLine();
            if (resposta.equalsIgnoreCase("sim")) {
                TesteInovacao.main();
            } else {
                System.out.println("O computador reiniciara em 10 minutos !");
                TimeUnit.SECONDS.sleep(600);
                TesteInovacao.main();
            }
        } else {
            System.out.println("safe");
        }
    }
}
