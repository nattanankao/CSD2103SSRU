package Group5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class WorkflowData {

    private final Deque<Action> eventStack;
    private final Deque<Action> redoStack;

    private State currentState;

    public WorkflowData() {

        eventStack = new ArrayDeque<>();
        redoStack = new ArrayDeque<>();

        currentState = State.NEW;
    }

    // =====================================================
    // EVENT STACK
    // =====================================================

    public Deque<Action> getEventStack() {
        return eventStack;
    }

    public void pushEvent(Action action) {
        eventStack.push(action);
    }

    public Action popEvent() {

        if (eventStack.isEmpty()) {
            return null;
        }

        return eventStack.pop();
    }

    // =====================================================
    // REDO STACK
    // =====================================================

    public Deque<Action> getRedoStack() {
        return redoStack;
    }

    public void pushRedo(Action action) {
        redoStack.push(action);
    }

    public Action popRedo() {

        if (redoStack.isEmpty()) {
            return null;
        }

        return redoStack.pop();
    }

    public void clearRedo() {
        redoStack.clear();
    }

    // =====================================================
    // CURRENT STATE
    // =====================================================

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State state) {
        currentState = state;
    }

    // =====================================================
    // RESET
    // =====================================================

    public void reset() {

        eventStack.clear();
        redoStack.clear();

        currentState = State.NEW;
    }

    // =====================================================
    // แสดง Event Stack จาก Bottom -> Top
    // =====================================================

    public List<Action> eventBottomToTop() {

        List<Action> result =
                new ArrayList<>(eventStack);

        /*
         * ArrayDeque iteration เป็น Top -> Bottom
         * จึงกลับลำดับเพื่อแสดง Bottom -> Top
         */
        java.util.Collections.reverse(result);

        return result;
    }

    // =====================================================
    // แสดง Redo Stack จาก Top -> Bottom
    // =====================================================

    public List<Action> redoTopToBottom() {

        return new ArrayList<>(redoStack);
    }
}