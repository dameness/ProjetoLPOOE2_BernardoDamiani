
import br.edu.ifsul.cc.lpoo.projetolpooe1_bernardodamiani.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo.projetolpooe1_bernardodamiani.model.Aluno;
import br.edu.ifsul.cc.lpoo.projetolpooe1_bernardodamiani.model.Disciplina;
import br.edu.ifsul.cc.lpoo.projetolpooe1_bernardodamiani.model.Professor;
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
         
         Aluno a1 = new Aluno();
         a1.setNome("Aluno X");
         a1.setTelefone("54996100976");
         
         Aluno a2 = new Aluno();
         a2.setNome("Aluno Y");
         a2.setTelefone("88886100976");
         
         Collection<Aluno> alunos = new ArrayList<>();
         alunos.add(a1);
         alunos.add(a2);
         
         d.setProfessor(p);
         d.setAlunos(alunos);
         
         Collection<Disciplina> disciplinas = new ArrayList<>();
         disciplinas.add(d);
         
         p.setDisciplinas(disciplinas);
        
         jpa.persist(a1);
         jpa.persist(a2);
        
         jpa.persist(d);
         jpa.persist(p);
     }
}
