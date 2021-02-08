package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Simulator;

class SimulatorTest {
	
	@BeforeEach                                         
    public void setUp() throws Exception {
		Simulator.clearQuestions();
    }
	
	@Test                                               
    @DisplayName("Adding a new question with a too big questiontext")   
    public void testAddQuestion1() {
        String input = "asdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkffasdkfasdkfasdkfasdkfasdkfasdkf? \"Test\"";
        assertEquals(2, Simulator.addNewQuestion(input));
    }
	
	@Test                                               
    @DisplayName("Adding a new question with a too big answertext")   
    public void testAddQuestion2() {
        String input = "Test? \"asdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkfasdkffasdkfasdkfasdkfasdkfasdkfasdkf\"";
        assertEquals(3, Simulator.addNewQuestion(input));
    }
	
	@Test                                               
    @DisplayName("Adding a new question with one answer")   
    public void testAddQuestion3() {
        String input = "What is Mario's favorite food? \"Spaghetti\"";
        assertEquals(5, Simulator.addNewQuestion(input));
    }
	
    @Test                                               
    @DisplayName("Adding a new question with more than one answers")   
    public void testAddQuestion4() {
        String input = "What is Peter's favorite food? \"Pizza\" \"Hot Dog\"";
        assertEquals(5, Simulator.addNewQuestion(input));
    }

    @Test                                   
    @DisplayName("Adding a new question without any answers")
    public void testAddQuestion5() {
    	String input = "What is Jessica's favorite food? \"\"";
        assertEquals(4, Simulator.addNewQuestion(input));
    }
    
    @Test                                   
    @DisplayName("Adding a new question with a wrong format")
    public void testAddQuestion6() {
    	String input = "What is Peter's favorite food \\\"Pizza\\\" \\\"Hot Dog\\\"";
        assertEquals(1, Simulator.addNewQuestion(input));
    }
    
    @Test                                   
    @DisplayName("Adding a new question without any input")
    public void testAddQuestion7() {
    	String input = "";
        assertEquals(0, Simulator.addNewQuestion(input));
    }
    
    @Test                                   
    @DisplayName("Asking a known Question")
    public void testAskQuestion1() {
    	String inputLine = "What is Peter's favorite food? \"Pizza\" \"Hot Dog\"";
    	String input = "What is Peter's favorite food?";
    	
    	Simulator.addNewQuestion(inputLine);
        assertNotNull(Simulator.askQuestion(input));
    }
    
    @Test                                   
    @DisplayName("Asking an unknown Question")
    public void testAskQuestion2() {
    	String inputLine = "What is Peter's favorite food? \"Pizza\" \"Hot Dog\"";
    	String input = "What is Mario's favorite food?";
    	
    	Simulator.addNewQuestion(inputLine);
        assertNull(Simulator.askQuestion(input));
    }
    
    @Test                                   
    @DisplayName("Asking a similar Question")
    public void testAskQuestion3() {
    	String inputLine = "What is Peter's favorite food? \"Pizza\" \"Hot Dog\"";
    	String input = "What's Peter's favorite food?";
    	
    	Simulator.addNewQuestion(inputLine);
        assertNull(Simulator.askQuestion(input));
    }

}
