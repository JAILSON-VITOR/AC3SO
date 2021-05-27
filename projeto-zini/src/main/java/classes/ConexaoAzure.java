package classes;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
public class ConexaoAzure {
    public  static JdbcTemplate jdbcTemplate;
    public  static BasicDataSource dataSource;
    
    public String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public String url = "jdbc:sqlserver://dbgsn.database.windows.net:1433;database=bd-gsn;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;";
    public String username = "guilherme";
    public String password = "#Gf49488852828";

    public ConexaoAzure() {
        Conectar();
    };
    
    

    public void Conectar(){
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
