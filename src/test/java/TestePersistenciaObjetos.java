
import br.edu.ifsul.cc.lpoo.projetolpooe2_bernardodamiani.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo.projetolpooe2_bernardodamiani.model.Aluno;
import br.edu.ifsul.cc.lpoo.projetolpooe2_bernardodamiani.model.Disciplina;
import br.edu.ifsul.cc.lpoo.projetolpooe2_bernardodamiani.model.Professor;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestePersistenciaObjetos {
    PersistenciaJPA jpa = new PersistenciaJPA();
    public TestePersistenciaObjetos() {
        
    }
    
    @Before
    public void setUp() {
        jpa.conexaoAberta();
    }
    
    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

     @Test
     public void test() throws Exception {
         Professor p = new Professor();
         p.setNome("Professor X");
         p.setSalario(5500.00);
         
         Disciplina d = new Disciplina();
         d.setCarga_horaria(20);
         d.setProfessor(p);
         
         Aluno a = new Aluno();
         a.setNome("Aluno X");
         a.setTelefone("9999999999");
         a.setDisciplina(d);
         
         jpa.persist(p);
         jpa.persist(d);
         jpa.persist(a);
     }
}
