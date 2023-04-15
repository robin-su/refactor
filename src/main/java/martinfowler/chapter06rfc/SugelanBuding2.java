package martinfowler.chapter06rfc;

public class SugelanBuding2 {

    private double _primaryForce;
    private double _mass;
    private int _delay;
    private double _secondaryForce;

    public SugelanBuding2(double _primaryForce, double _mass, int _delay, double _secondaryForce) {
        this._primaryForce = _primaryForce;
        this._mass = _mass;
        this._delay = _delay;
        this._secondaryForce = _secondaryForce;
    }

    double getDistanceTravelled(int time) {
        double result = 0.5 * getPrimaryAcc() * getPrimaryTime(time) * getPrimaryTime(time);
        if(getSecondaryTime(time) > 0) {
            result += getSecondDistance(time);
        }
        return result;
    }

    private double getSecondDistance(int time) {
        double primaryVel = getPrimaryAcc() * _delay;
        return primaryVel * getSecondaryTime(time) + 0.5 * getSecondaryAcc() * getSecondaryTime(time) * getSecondaryTime(time);
    }

    private double getSecondaryAcc() {
        return (_primaryForce + _secondaryForce) / _mass;
    }

    private int getSecondaryTime(int time) {
        return time - _delay;
    }

    private int getPrimaryTime(int time) {
        return Math.min(time, _delay);
    }

    private double getPrimaryAcc() {
        return _primaryForce / _mass;
    }

}
