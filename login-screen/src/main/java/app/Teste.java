/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import inovacao.TesteInovacao;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import sql.Conection;

/**
 *
 * @author Rainha Katarine I
 */
public class Teste {

    public static void main(String[] args) throws InterruptedException, IOException {
        InserirMetrica im = new InserirMetrica();
        InfoPc infoPc = new InfoPc();
        inovacao.Inovacao in = new inovacao.Inovacao();
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();
        Scanner scan = new Scanner(System.in);
        String hostname = infoPc.hostName();
        Alerta al = new Alerta();
        
//        System.out.println(al.parametroRedeAmarelo());;
//        System.out.println(al.parametroRedeVermelho());
//        al.alertaRede();
        
        System.out.println(im.fkConfigRede());
//        List teste = im.inserirMetrica();
        
//        System.out.println(in.setor());
        
//        System.out.println(hostname);
//    
//        System.out.println(in.setor());
//        String insert1 = teste.get(0).toString();
//        System.out.println(insert1);
//        JSONObject json = new JSONObject();
//        json.put("text", "Teste link na nuvem depois do push no git e 12hrs - general e o hostname é :" + hostname);
//        slack.Slack.sendMessage(json);
//        JSONObject json2 = new JSONObject();
//        json2.put("text", "Teste dois canais - monitoramento de hardware");
//
// 
//        slack.Slack.sendMessage2(json2);

//        TesteInovacao.main();
//         con.update("update [dbo].[historicoReiniciar] "
//                        + "set tempoReiniciar = 0 "
//                        + "where fkComputador = ?;", hostname);
//        System.out.println(in.verificarData());
//            in.reiniciar();
//        System.out.println(in.fkEmpresa()); 
//        System.out.println(in.valorParametro());
//        System.out.println(in.verificarNecessidade());
//        System.out.println(im.inserirMetrica());
//            System.out.println(im.fkConfigRam());
//            im.inserirMetrica();
//        String hostname = infoPc.hostName();
//           System.out.println(hostname); 
//        System.out.println(im.fkConfigRam());
//        System.out.println(im.fkConfigRede());
//        System.out.println(im.fkConfigCpu());
//        System.out.println(im.fkConfigArmazenamento());
//        System.out.println("*******************************");
//        System.out.println(im.fkConfigRam2());
//        System.out.println(im.fkConfigRede2());
//        System.out.println(im.fkConfigCpu2());
//        System.out.println(im.fkConfigArmazenamento2());
//        System.out.println(im.ping() + "MS");
//        System.out.println(im.teste());
//        new Timer().scheduleAtFixedRate(new TimerTask() {
//
//            public void run() {
//                System.out.println(im.getUsoAtualDisco() + " Disco");
//                System.out.println(im.getUsoAtualRam() + " RAM");
//                System.out.println(im.getUsoAtualCpu() + " CPU");
//                System.out.println(im.ping() + "MS");
//            }
//        }, 0, 5000);
    }
}
