package Group5;

public class Event_Stack extends WorkflowAlgorithm {

    @Override
    public String getName() {

        return "Algorithm A - Event Stack";
    }

    // =====================================================
    // ADD ACTION
    // =====================================================

    @Override
    public boolean addAction(Action newAction) {

        if (newAction == null) {
            return false;
        }

        /*
         * Algorithm A
         * ต้อง Replay Event Stack
         * เพื่อหาสถานะปัจจุบัน
         */

        State calculatedState =
                State.NEW;

        for (Action action :
                data.eventBottomToTop()) {

            loopCount++;

            State next =
                    transition(
                            calculatedState,
                            action);

            if (next == null) {
                return false;
            }

            calculatedState = next;
        }

        /*
         * ตรวจสอบ Action ใหม่
         */

        State nextState =
                transition(
                        calculatedState,
                        newAction);

        if (nextState == null) {
            return false;
        }

        /*
         * เพิ่ม Action
         */

        data.pushEvent(newAction);

        pushCount++;

        /*
         * เพิ่ม Action ใหม่
         * ต้องล้าง Redo Stack
         */

        data.clearRedo();

        /*
         * Update State
         */

        data.setCurrentState(nextState);

        return true;
    }

    // =====================================================
    // UNDO
    // =====================================================

    @Override
    public boolean undo() {

        if (data.getEventStack().isEmpty()) {
            return false;
        }

        Action removed =
                data.popEvent();

        popCount++;

        data.pushRedo(removed);

        pushCount++;

        movedDataCount++;

        /*
         * Algorithm A ต้อง Replay Stack
         * เพื่อหา State ใหม่
         */

        State calculatedState =
                State.NEW;

        for (Action action :
                data.eventBottomToTop()) {

            loopCount++;

            State next =
                    transition(
                            calculatedState,
                            action);

            if (next == null) {
                return false;
            }

            calculatedState = next;
        }

        data.setCurrentState(
                calculatedState);

        return true;
    }

    // =====================================================
    // REDO
    // =====================================================

    @Override
    public boolean redo() {

        if (data.getRedoStack().isEmpty()) {
            return false;
        }

        Action action =
                data.popRedo();

        popCount++;

        /*
         * หา State จาก Event Stack
         */

        State calculatedState =
                State.NEW;

        for (Action oldAction :
                data.eventBottomToTop()) {

            loopCount++;

            State next =
                    transition(
                            calculatedState,
                            oldAction);

            if (next == null) {
                return false;
            }

            calculatedState = next;
        }

        /*
         * ตรวจสอบ Action ที่จะ Redo
         */

        State nextState =
                transition(
                        calculatedState,
                        action);

        if (nextState == null) {

            /*
             * ถ้าไม่ถูกต้อง ให้คืน Action
             */
            data.pushRedo(action);
            pushCount++;

            return false;
        }

        data.pushEvent(action);

        pushCount++;

        movedDataCount++;

        data.setCurrentState(
                nextState);

        return true;
    }
}