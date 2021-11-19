package base.entity;


public class RankItem {
    private Integer score;
    private TestUser user;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public TestUser getUser() {
        return user;
    }

    public void setUser(TestUser user) {
        this.user = user;
    }
}
