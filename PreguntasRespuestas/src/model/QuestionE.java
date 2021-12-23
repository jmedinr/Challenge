
package model;

/**
 *
 * @author jmedinr
 */
public class QuestionE {
    private String question;
    private int round;
    private int prize;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String answer;

    public QuestionE(String question, int roud, int prize, String answerA, String answerB, String answerC, String answerD, String answer) {
        this.question = question;
        this.round = roud;
        this.prize = prize;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.answer = answer;
    }
    
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int roud) {
        this.round = roud;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "QuestionE{" + "question=" + question + ", round=" + round + ", prize=" + prize + ", answerA=" + answerA + ", answerB=" + answerB + ", answerC=" + answerC + ", answerD=" + answerD + ", answer=" + answer + '}';
    }
    
    
}
