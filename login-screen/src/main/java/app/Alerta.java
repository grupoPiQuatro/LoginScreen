/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import inovacao.Inovacao;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Metrica;
import org.json.JSONObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import sql.Conection;

/**
 *
 * @author Rainha Katarine I
 */
public class Alerta {

    public Integer parametroRedeVermelho() {
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();
        inovacao.Inovacao in = new inovacao.Inovacao();

        return con.queryForObject("select valor from Parametros where fkAlerta = 1 and fkEmpresa = ? and fkComponente = 1", Integer.class, in.fkEmpresa());
    }

    public Integer parametroRedeAmarelo() {
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();
        inovacao.Inovacao in = new inovacao.Inovacao();

        return con.queryForObject("select valor from Parametros where fkAlerta = 2 and fkEmpresa = ? and fkComponente = 1", Integer.class, in.fkEmpresa());
    }

    public Integer parametroRamVermelho() {
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();
        inovacao.Inovacao in = new inovacao.Inovacao();

        return con.queryForObject("select valor from Parametros where fkAlerta = 1 and fkEmpresa = ? and fkComponente = 2", Integer.class, in.fkEmpresa());
    }

    public Integer parametroRamAmarelo() {
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();
        inovacao.Inovacao in = new inovacao.Inovacao();

        return con.queryForObject("select valor from Parametros where fkAlerta = 2 and fkEmpresa = ? and fkComponente = 2", Integer.class, in.fkEmpresa());
    }

    public Integer parametroCpuVermelho() {
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();
        inovacao.Inovacao in = new inovacao.Inovacao();

        return con.queryForObject("select valor from Parametros where fkAlerta = 1 and fkEmpresa = ? and fkComponente = 3", Integer.class, in.fkEmpresa());
    }

    public Integer parametroCpuAmarelo() {
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();
        inovacao.Inovacao in = new inovacao.Inovacao();

        return con.queryForObject("select valor from Parametros where fkAlerta = 2 and fkEmpresa = ? and fkComponente = 3", Integer.class, in.fkEmpresa());
    }

    public Integer parametroMemoriaVermelho() {
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();
        inovacao.Inovacao in = new inovacao.Inovacao();

        return con.queryForObject("select valor from Parametros where fkAlerta = 1 and fkEmpresa = ? and fkComponente = 4", Integer.class, in.fkEmpresa());
    }

    public Integer parametroMemoriaAmarelo() {
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();
        inovacao.Inovacao in = new inovacao.Inovacao();

        return con.queryForObject("select valor from Parametros where fkAlerta = 2 and fkEmpresa = ? and fkComponente = 4", Integer.class, in.fkEmpresa());
    }

    public void alertaRede() {
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();
        InserirMetrica im = new InserirMetrica();
        inovacao.Inovacao in = new inovacao.Inovacao();
        InfoPc infoPc = new InfoPc();
        String hostname = infoPc.hostName();

        List<Metrica> metrica = con.query("select top 6 * from Metrica where fkConfig = ? order by dtCaptura desc ;",
                new BeanPropertyRowMapper(Metrica.class), im.fkConfigRede());

        Boolean response = false;
        Boolean response1 = false;
        System.out.println(metrica);
        for (Metrica met : metrica) {
            if (met.getValor() > parametroRedeAmarelo()) {
                response = true;
            } else {
                response = false;
            }

            if (met.getValor() > parametroRedeVermelho()) {
                response1 = true;
            } else {
                response1 = false;
            }
        }
        System.out.println("amarelo: " + response);
        System.out.println("vermelho: " + response1);
        if (response) {
            try {
                JSONObject json = new JSONObject();
                String setor = in.setor();
                json.put("text", "Alerta Rede - AMARELO\n"
                        + "\nSetor: " + setor
                        + "\nHostname: " + hostname);

                con.update("insert historicoAlerta (fkAlerta,fkMetrica, dtCaptura) values (2,?, CONVERT(VARCHAR, DATEADD(HOUR, -3, GETDATE()), 120));", metrica.get(5).getIdMetrica());
                slack.Slack.sendMessage(json);
            } catch (IOException ex) {
                Logger.getLogger(Alerta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Alerta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (response1) {
            try {
                JSONObject json = new JSONObject();
                String setor = in.setor();
                json.put("text", "Alerta Rede - VERMELHO\n"
                        + "\nSetor: " + setor
                        + "\nHostname: " + hostname);

                con.update("insert historicoAlerta (fkAlerta,fkMetrica, dtCaptura) values (1,?, CONVERT(VARCHAR, DATEADD(HOUR, -3, GETDATE()), 120));", metrica.get(5).getIdMetrica());
                slack.Slack.sendMessage(json);
            } catch (IOException ex) {
                Logger.getLogger(Alerta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Alerta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void alertaRam() {
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();
        InserirMetrica im = new InserirMetrica();
        inovacao.Inovacao in = new inovacao.Inovacao();
        InfoPc infoPc = new InfoPc();
        String hostname = infoPc.hostName();

        List<Metrica> metrica = con.query("select top 6 * from Metrica where fkConfig = ? order by dtCaptura desc ;",
                new BeanPropertyRowMapper(Metrica.class), im.fkConfigRam());

        Boolean response = false;
        Boolean response1 = false;

        for (Metrica met : metrica) {
            if (met.getValor() > parametroRamAmarelo()) {
                response = true;
            } else {
                response = false;
            }

            if (met.getValor() > parametroRamVermelho()) {
                response1 = true;
            } else {
                response1 = false;
            }
        }

        if (response) {
            try {
                JSONObject json = new JSONObject();
                String setor = in.setor();
                json.put("text", "Alerta RAM - AMARELO\n"
                        + "\nSetor: " + setor
                        + "\nHostname: " + hostname);

                con.update("insert historicoAlerta (fkAlerta,fkMetrica, dtCaptura) values (2,?, CONVERT(VARCHAR, DATEADD(HOUR, -3, GETDATE()), 120));", metrica.get(5).getIdMetrica());
                slack.Slack.sendMessage(json);
            } catch (IOException ex) {
                Logger.getLogger(Alerta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Alerta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (response1) {
            try {
                JSONObject json = new JSONObject();
                String setor = in.setor();
                json.put("text", "Alerta RAM - VERMELHO\n"
                        + "\nSetor: " + setor
                        + "\nHostname: " + hostname);

                con.update("insert historicoAlerta (fkAlerta,fkMetrica, dtCaptura) values (1,?, CONVERT(VARCHAR, DATEADD(HOUR, -3, GETDATE()), 120));", metrica.get(5).getIdMetrica());
                slack.Slack.sendMessage(json);
            } catch (IOException ex) {
                Logger.getLogger(Alerta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Alerta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void alertaCpu() {
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();
        InserirMetrica im = new InserirMetrica();
        inovacao.Inovacao in = new inovacao.Inovacao();
        InfoPc infoPc = new InfoPc();
        String hostname = infoPc.hostName();

        List<Metrica> metrica = con.query("select top 6 * from Metrica where fkConfig = ? order by dtCaptura desc ;",
                new BeanPropertyRowMapper(Metrica.class), im.fkConfigCpu());

        Boolean response = false;
        Boolean response1 = false;

        for (Metrica met : metrica) {
            if (met.getValor() > parametroCpuAmarelo()) {
                response = true;
            } else {
                response = false;
            }

            if (met.getValor() > parametroCpuVermelho()) {
                response1 = true;
            } else {
                response1 = false;
            }
        }

        if (response) {
            try {
                JSONObject json = new JSONObject();
                String setor = in.setor();
                json.put("text", "Alerta CPU - AMARELO\n"
                        + "\nSetor: " + setor
                        + "\nHostname: " + hostname);

                con.update("insert historicoAlerta (fkAlerta,fkMetrica, dtCaptura) values (2,?, CONVERT(VARCHAR, DATEADD(HOUR, -3, GETDATE()), 120));", metrica.get(5).getIdMetrica());
                slack.Slack.sendMessage(json);
            } catch (IOException ex) {
                Logger.getLogger(Alerta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Alerta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (response1) {
            try {
                JSONObject json = new JSONObject();
                String setor = in.setor();
                json.put("text", "Alerta CPU - VERMELHO\n"
                        + "\nSetor: " + setor
                        + "\nHostname: " + hostname);

                con.update("insert historicoAlerta (fkAlerta,fkMetrica, dtCaptura) values (1,?, CONVERT(VARCHAR, DATEADD(HOUR, -3, GETDATE()), 120));", metrica.get(5).getIdMetrica());
                slack.Slack.sendMessage(json);
            } catch (IOException ex) {
                Logger.getLogger(Alerta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Alerta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void alertaMemoria() {
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();
        InserirMetrica im = new InserirMetrica();
        inovacao.Inovacao in = new inovacao.Inovacao();
        InfoPc infoPc = new InfoPc();
        String hostname = infoPc.hostName();

        List<Metrica> metrica = con.query("select top 6 * from Metrica where fkConfig = ? order by dtCaptura desc ;",
                new BeanPropertyRowMapper(Metrica.class), im.fkConfigArmazenamento());

        Boolean response = false;
        Boolean response1 = false;

        for (Metrica met : metrica) {
            if (met.getValor() > parametroMemoriaAmarelo()) {
                response = true;
            } else {
                response = false;
            }

            if (met.getValor() > parametroMemoriaVermelho()) {
                response1 = true;
            } else {
                response1 = false;
            }
        }

        if (response) {
            try {
                JSONObject json = new JSONObject();
                String setor = in.setor();
                json.put("text", "Alerta Armazenamento - AMARELO\n"
                        + "\nSetor: " + setor
                        + "\nHostname: " + hostname);

                con.update("insert historicoAlerta (fkAlerta,fkMetrica, dtCaptura) values (2,?, CONVERT(VARCHAR, DATEADD(HOUR, -3, GETDATE()), 120));", metrica.get(5).getIdMetrica());
                slack.Slack.sendMessage(json);
            } catch (IOException ex) {
                Logger.getLogger(Alerta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Alerta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (response1) {
            try {
                JSONObject json = new JSONObject();
                String setor = in.setor();
                json.put("text", "Alerta Armazenamento - VERMELHO\n"
                        + "\nSetor: " + setor
                        + "\nHostname: " + hostname);

                con.update("insert historicoAlerta (fkAlerta,fkMetrica, dtCaptura) values (1,?, CONVERT(VARCHAR, DATEADD(HOUR, -3, GETDATE()), 120));", metrica.get(5).getIdMetrica());
                slack.Slack.sendMessage(json);
            } catch (IOException ex) {
                Logger.getLogger(Alerta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(Alerta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
