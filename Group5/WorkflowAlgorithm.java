package Group5;

public abstract class WorkflowAlgorithm {

    protected WorkflowData data;

    protected long pushCount;
    protected long popCount;
    protected long comparisonCount;
    protected long loopCount;
    protected long movedDataCount;

    public WorkflowAlgorithm() {

        data = new WorkflowData();

        resetCounters();
    }

    // =====================================================
    // METHODS ที่ Algorithm ต้องมี
    // =====================================================

    public abstract boolean addAction(Action action);

    public abstract boolean undo();

    public abstract boolean redo();

    public abstract String getName();

    // =====================================================
    // TRANSITION
    // =====================================================

    protected State transition(
            State current,
            Action action) {

        comparisonCount++;

        switch (current) {

            case NEW:

                if (action == Action.CALL_RECEIVED) {
                    return State.RECEIVED;
                }

                break;

            case RECEIVED:

                if (action == Action.TEAM_ASSIGNED) {
                    return State.ASSIGNED;
                }

                break;

            case ASSIGNED:

                if (action == Action.VEHICLE_DISPATCHED) {
                    return State.DISPATCHED;
                }

                break;

            case DISPATCHED:

                if (action == Action.ARRIVED_AT_SCENE) {
                    return State.ON_SCENE;
                }

                break;

            case ON_SCENE:

                if (action == Action.CASE_CLOSED) {
                    return State.CLOSED;
                }

                break;

            case CLOSED:

                break;
        }

        return null;
    }

    // =====================================================
    // PREVIOUS STATE
    // ใช้สำหรับ Undo ของ Algorithm B
    // =====================================================

    protected State previousState(
            State current,
            Action action) {

        comparisonCount++;

        switch (action) {

            case CALL_RECEIVED:

                if (current == State.RECEIVED) {
                    return State.NEW;
                }

                break;

            case TEAM_ASSIGNED:

                if (current == State.ASSIGNED) {
                    return State.RECEIVED;
                }

                break;

            case VEHICLE_DISPATCHED:

                if (current == State.DISPATCHED) {
                    return State.ASSIGNED;
                }

                break;

            case ARRIVED_AT_SCENE:

                if (current == State.ON_SCENE) {
                    return State.DISPATCHED;
                }

                break;

            case CASE_CLOSED:

                if (current == State.CLOSED) {
                    return State.ON_SCENE;
                }

                break;
        }

        return null;
    }

    // =====================================================
    // DATA
    // =====================================================

    public WorkflowData getData() {
        return data;
    }

    public State getCurrentState() {
        return data.getCurrentState();
    }

    // =====================================================
    // RESET
    // =====================================================

    public void reset() {

        data.reset();

        resetCounters();
    }

    protected void resetCounters() {

        pushCount = 0;
        popCount = 0;
        comparisonCount = 0;
        loopCount = 0;
        movedDataCount = 0;
    }

    // =====================================================
    // OPERATION COUNT
    // =====================================================

    public long getPushCount() {
        return pushCount;
    }

    public long getPopCount() {
        return popCount;
    }

    public long getComparisonCount() {
        return comparisonCount;
    }

    public long getLoopCount() {
        return loopCount;
    }

    public long getMovedDataCount() {
        return movedDataCount;
    }

    // =====================================================
    // INVARIANT
    // =====================================================

    public boolean isInvariantValid() {

        State calculatedState = State.NEW;

        for (Action action : data.eventBottomToTop()) {

            State next =
                    transition(calculatedState, action);

            if (next == null) {
                return false;
            }

            calculatedState = next;
        }

        return calculatedState ==
                data.getCurrentState();
    }
}