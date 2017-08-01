package huangshun.it.com.androiddesignpattern.test.sleepBlock;

/**
 * Created by hs on 2017/7/31.
 */

class DBRawData {
    private Long id;
    private Long timestamp;
    private Short quiet;
    private Short alert;
    private Short move;
    private Short walk;
    private Short run;
    private Short swim;
    private Short bongflag;
    private Short chargeflag;
    private Short steps;
    private Integer amp;
    private Integer heartrate;

    public DBRawData() {
    }

    public DBRawData(Long id) {
        this.id = id;
    }

    public DBRawData(Long id, Long timestamp, Short quiet, Short alert, Short move, Short walk, Short run, Short swim, Short bongflag, Short chargeflag, Short steps, Integer amp, Integer heartrate) {
        this.id = id;
        this.timestamp = timestamp;
        this.quiet = quiet;
        this.alert = alert;
        this.move = move;
        this.walk = walk;
        this.run = run;
        this.swim = swim;
        this.bongflag = bongflag;
        this.chargeflag = chargeflag;
        this.steps = steps;
        this.amp = amp;
        this.heartrate = heartrate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Short getQuiet() {
        return quiet;
    }

    public void setQuiet(Short quiet) {
        this.quiet = quiet;
    }

    public Short getAlert() {
        return alert;
    }

    public void setAlert(Short alert) {
        this.alert = alert;
    }

    public Short getMove() {
        return move;
    }

    public void setMove(Short move) {
        this.move = move;
    }

    public Short getWalk() {
        return walk;
    }

    public void setWalk(Short walk) {
        this.walk = walk;
    }

    public Short getRun() {
        return run;
    }

    public void setRun(Short run) {
        this.run = run;
    }

    public Short getSwim() {
        return swim;
    }

    public void setSwim(Short swim) {
        this.swim = swim;
    }

    public Short getBongflag() {
        return bongflag;
    }

    public void setBongflag(Short bongflag) {
        this.bongflag = bongflag;
    }

    public Short getChargeflag() {
        return chargeflag;
    }

    public void setChargeflag(Short chargeflag) {
        this.chargeflag = chargeflag;
    }

    public Short getSteps() {
        return steps;
    }

    public void setSteps(Short steps) {
        this.steps = steps;
    }

    public Integer getAmp() {
        return amp;
    }

    public void setAmp(Integer amp) {
        this.amp = amp;
    }

    public Integer getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(Integer heartrate) {
        this.heartrate = heartrate;
    }

}
