/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inovacao;

import com.github.britooo.looca.api.core.Looca;
import com.mycompany.loginscreen.Componente;
import com.mycompany.loginscreen.Conection;
import com.mycompany.loginscreen.InfoPc;
import com.mycompany.loginscreen.InserirMetrica;
import com.mycompany.loginscreen.Metrica;
import java.util.List;
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
   
   public Integer fkEmpresa(){
       Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();
        InfoPc infoPc = new InfoPc();

        String hostname = infoPc.hostName();
       
       return con.queryForObject("select fkEmpresa from Computador where hostname = ?",Integer.class,hostname);
   }
   
   public Integer valorParametro(){
        Conection conexao = new Conection();
        JdbcTemplate con = conexao.getConnection();
        
        
       return con.queryForObject("select valor from Parametros where fkAlerta = 1 and fkEmpresa = ? and fkComponente = 2", Integer.class,fkEmpresa());
   }
   
   public List verificarNecessidade(){
       Conection conexao = new Conection();
       JdbcTemplate con = conexao.getConnection();
       InserirMetrica im = new InserirMetrica();
       
       List<String> listaMetrica = con.query(
       "select top 10 case when valor  >  ?  then 'true' else 'false' end as valor from [dbo].[metrica] where fkConfig = ? order by dtCaptura desc;",
       new BeanPropertyRowMapper(String.class), valorParametro(), im.fkConfigRam()
       );
       
     return listaMetrica;  
   }
}
