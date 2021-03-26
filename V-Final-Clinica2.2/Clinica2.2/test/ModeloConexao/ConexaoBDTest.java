/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloConexao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Henrique
 */
public class ConexaoBDTest {
    
    ConexaoBD c ;
    public ConexaoBDTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        c= new ConexaoBD();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of Conexao method, of class ConexaoBD.
     */
    @Test
    public void testConexao() {
      c.Conexao();
    }

    /**
     * Test of ExecutaSql method, of class ConexaoBD.
     */
    @Test
    public void testExecutaSql() {
       c.ExecutaSql("select *from clientes");
    }

    /**
     * Test of Desconecta method, of class ConexaoBD.
     */
    @Test
    public void testDesconecta() {
         c.Desconecta();
    }
    
}
