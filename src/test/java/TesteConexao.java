

import br.edu.ifsul.cc.lpoo.projetolpooe1_bernardodamiani.dao.PersistenciaJPA;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteConexao {
    
    public TesteConexao() {
        
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void hello() {
     PersistenciaJPA jpa = new PersistenciaJPA();
        if(jpa.conexaoAberta()){
            System.out.println("Conectado ao BD");
        } else {
            System.err.println("Erro ao conectar ao banco");
        }
     }
}
