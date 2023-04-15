package martinfowler.chapter06rfc;

public class SugelanBuding {

    private double _primaryForce;
    private double _mass;
    private int _delay;
    private double _secondaryForce;

    public SugelanBuding(double _primaryForce, double _mass, int _delay, double _secondaryForce) {
        this._primaryForce = _primaryForce;
        this._mass = _mass;
        this._delay = _delay;
        this._secondaryForce = _secondaryForce;
    }

    double getDistanceTravelled(int time) {
        double result;
        final double primaryAcc = _primaryForce / _mass;
        int primaryTime = Math.min(time, _delay);
        result = 0.5 * primaryAcc * primaryTime * primaryTime;
        int secondaryTime = time - _delay;
        if(secondaryTime > 0) {
           double primaryVel = primaryAcc * _delay;
           final double secondaryAcc = (_primaryForce + _secondaryForce) / _mass;
           result += primaryVel * secondaryTime + 0.5 * secondaryAcc * secondaryTime * secondaryTime;
        }
        return result;
    }

}
