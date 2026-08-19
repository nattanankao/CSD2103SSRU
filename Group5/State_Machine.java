package Group5;

public class State_Machine extends WorkflowAlgorithm {

    @Override
    public String getName() {

        return "Algorithm B - Event Stack + State Machine";
    }

    // =====================================================
    // ADD ACTION
    // =====================================================

    @Override
    public boolean addAction(Action action) {

        if (action == null) {
            return false;
        }

        /*
         * ใช้ currentState โดยตรง
         * ไม่ต้อง Replay Event Stack
         */

        State nextState =
                transition(
                        data.getCurrentState(),
                        action);

        /*
         * Transition ผิดลำดับ
         */

        if (nextState == null) {
            return false;
        }

        /*
         * เพิ่ม Action
         */

        data.pushEvent(action);

        pushCount++;

        /*
         * กฎ:
         * เพิ่ม Action ใหม่หลัง Undo/Redo
         * ต้องล้าง Redo Stack
         */

        data.clearRedo();

        /*
         * Update State
         */

        data.setCurrentState(
                nextState);

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

        Action action =
                data.popEvent();

        popCount++;

        /*
         * หาสถานะก่อนหน้าโดยตรง
         */

        State previous =
                previousState(
                        data.getCurrentState(),
                        action);

        if (previous == null) {

            /*
             * คืนข้อมูลถ้าเกิดข้อผิดพลาด
             */

            data.pushEvent(action);

            pushCount++;

            return false;
        }

        data.pushRedo(action);

        pushCount++;

        movedDataCount++;

        data.setCurrentState(previous);

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
         * ตรวจ Action จาก currentState
         */

        State nextState =
                transition(
                        data.getCurrentState(),
                        action);

        if (nextState == null) {

            /*
             * คืน Action ถ้า Transition ผิด
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