/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import sql.Conection;
import sql.ConectionMySql;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.processador.ProcessadorCacheLoader;
import java.io.IOException;
import java.util.List;
import java.net.InetAddress;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Random;
import tela.de.captura.TelaDeCaptura;

/**
 *
 * @author Rainha Katarine I
 */
public class InserirMetrica {

    private Looca looca;

    public InserirMetrica() {
        this.looca = new Looca();
    }

    public Double getUsoAtualDisco() {
        List<Volume> volumes = looca.getGrupoDeDiscos().getVolumes();

        long l = volumes.get(0).getDisponivel();
        long g = volumes.get(0).getTotal();

        Double response = Math.floor(((l / (1024 * 1024 * 1024))) * 100) / 100;
        Double response1 = Math.floor(((g / (1024 * 1024 * 1024))) * 100) / 100;
        
        
        if(response1 < 100){
           response1 = 30.0; 
        } else if (response1 < 256) {
            response1 = 256.0;
        } else if (response1 < 512) {
            response1 = 512.0;
        } else {
            response1 = 1024.0;
        }

        Double emUso = response1 - response;
        return emUso;
    }

    public Double getUsoAtualRam() {
        long ram = looca.getMemoria().getEmUso();
        Double r = (double) ram;
        Double usoRam = Math.floor(((r / (1024 * 1024 * 1024))) * 100) / 100;
        return usoRam;
    }

    public Double getUsoAtualCpu() {
        Double usoCpuCheio = looca.getProcessador().getUso();
        Double usoCpu = Math.floor(usoCpuCheio * 100) / 100;
        return usoCpu;
    }

    public Long ping() {
        Random rn = new Random();
        String host = "www.google.com"; // Especifique o host que você deseja pingar
        Long ping = null;
        try {
            InetAddress inetAddress = InetAddress.getByName(host);
            long startTime = System.currentTimeMillis();
            if (inetAddress.isReachable(5000)) { // Timeout de 5 segundos
                long endTime = System.currentTimeMillis();
                long pingTime = endTime - startTime;
                ping = pingTime;
            } else {
                System.out.println("Ping para " + host + " falhou.");
                ping = rn.nextLong(25);
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro durante o ping: " + e.getMessage());
        }

        return ping;
    }

    public Integer fkConfigRede() {
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();
        InfoPc infoPc = new InfoPc();

        String hostname = infoPc.hostName();

        return con.queryForObject("select c.idConfig from Config c\n"
                + "join Componente cp on cp.idComponente = c.fkComponente\n"
                + "where cp.fkTipo in (1) and c.fkComputador = ?;", Integer.class, hostname);
    }

    public Integer fkConfigRam() {
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();

        InfoPc infoPc = new InfoPc();
        String hostname = infoPc.hostName();

        return con.queryForObject("select c.idConfig from Config c join Componente cp on cp.idComponente = c.fkComponente where cp.fkTipo  in (2) and c.fkComputador = ?;", Integer.class, hostname);
    }

    public Integer fkConfigCpu() {
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();
        InfoPc infoPc = new InfoPc();

        String hostname = infoPc.hostName();

        return con.queryForObject("select c.idConfig from Config c\n"
                + "join Componente cp on cp.idComponente = c.fkComponente\n"
                + "where cp.fkTipo in (3) and c.fkComputador = ?;", Integer.class, hostname);
    }

    public Integer fkConfigArmazenamento() {
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();
        InfoPc infoPc = new InfoPc();

        String hostname = infoPc.hostName();

        return con.queryForObject("select c.idConfig from Config c\n"
                + "join Componente cp on cp.idComponente = c.fkComponente\n"
                + "where cp.fkTipo in (4,5) and c.fkComputador = ?;", Integer.class, hostname);
    }

    public Integer fkConfigRede2() {
        ConectionMySql conexao = new ConectionMySql();
        JdbcTemplate con = conexao.getConnection();
        InfoPc infoPc = new InfoPc();

        String hostname = infoPc.hostName();

        return con.queryForObject("select c.idConfig from Config c\n"
                + "join Componente cp on cp.idComponente = c.fkComponente\n"
                + "where cp.fkTipo in (1) and c.fkComputador = ?;", Integer.class, hostname);
    }

    public Integer fkConfigRam2() {
        ConectionMySql conexao = new ConectionMySql();
        JdbcTemplate con = conexao.getConnection();

        InfoPc infoPc = new InfoPc();
        String hostname = infoPc.hostName();

        return con.queryForObject("select c.idConfig from Config c join Componente cp on cp.idComponente = c.fkComponente where cp.fkTipo  in (2) and c.fkComputador = ?;", Integer.class, hostname);
    }

    public Integer fkConfigCpu2() {
        ConectionMySql conexao = new ConectionMySql();
        JdbcTemplate con = conexao.getConnection();
        InfoPc infoPc = new InfoPc();

        String hostname = infoPc.hostName();

        return con.queryForObject("select c.idConfig from Config c\n"
                + "join Componente cp on cp.idComponente = c.fkComponente\n"
                + "where cp.fkTipo in (3) and c.fkComputador = ?;", Integer.class, hostname);
    }

    public Integer fkConfigArmazenamento2() {
        ConectionMySql conexao = new ConectionMySql();
        JdbcTemplate con = conexao.getConnection();
        InfoPc infoPc = new InfoPc();

        String hostname = infoPc.hostName();

        return con.queryForObject("select c.idConfig from Config c\n"
                + "join Componente cp on cp.idComponente = c.fkComponente\n"
                + "where cp.fkTipo in (4,5) and c.fkComputador = ?;", Integer.class, hostname);
    }

    public String inserirMetrica() {
        InfoPc ip = new InfoPc();
        
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();

        ConectionMySql conexao2 = new ConectionMySql();
        JdbcTemplate con2 = conexao2.getConnection();

                Long rede = ping();
                Double ramAtual = getUsoAtualRam();
                Double totalRam = ip.qtdRam();
                Double ram = (ramAtual/totalRam)*100;
                
                Double cpu = getUsoAtualCpu();
                Double discoAtual = getUsoAtualDisco();
                Double discoTotal = ip.qtdArmazenamento();
                Double disco = (discoAtual/discoTotal)*100;


                int azurePing = con.update("insert into Metrica (valor, unidade,dtCaptura,fkConfig) values(?,'ms',current_timestamp,?)", rede, fkConfigRede());
                int azureRam = con.update("insert into Metrica (valor, unidade,dtCaptura,fkConfig) values(?,'%',current_timestamp,?)", ram, fkConfigRam());
                int azureCpu = con.update("insert into Metrica (valor, unidade,dtCaptura,fkConfig) values(?,'%',current_timestamp,?)", cpu, fkConfigCpu());
                int azureArmazenamento = con.update("insert into Metrica (valor, unidade,dtCaptura,fkConfig) values(?,'gb',current_timestamp,?)", disco, fkConfigArmazenamento());

                int pingLocal = con2.update("insert into Metrica (valor, unidade,dtCaptura,fkConfig) values(?,'ms',current_timestamp,?)", rede, fkConfigRede2());
                int ramLocal = con2.update("insert into Metrica (valor, unidade,dtCaptura,fkConfig) values(?,'%',current_timestamp,?)", ram, fkConfigRam2());
                int cpuLocal = con2.update("insert into Metrica (valor, unidade,dtCaptura,fkConfig) values(?,'%',current_timestamp,?)", cpu, fkConfigCpu2());
                int armazenamentoLocal = con2.update("insert into Metrica (valor, unidade,dtCaptura,fkConfig) values(?,'gb',current_timestamp,?)", disco, fkConfigArmazenamento2());
                System.out.println("ok");
        return impressao(rede, ram, cpu, disco);
        
    }
    
    public String impressao(Long rede, Double ram, Double cpu, Double disco){
        
        String response = String.format("""
                                        %d MS | 
                                        %.2f %% RAM | 
                                        %.2f %% CPU | 
                                        %.2f GB Disco
                                        """, rede,ram,cpu,disco);
        
        return response ;
    }
}
