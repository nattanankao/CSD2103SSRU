package Group5;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner =
            new Scanner(System.in);

    /*
     * เริ่มต้นด้วย Algorithm B
     */
    private static WorkflowAlgorithm algorithm =
            new State_Machine();

    public static void main(String[] args) {

        boolean running = true;

        System.out.println(
                "==============================================");

        System.out.println(
                "       EMERGENCY WORKFLOW - GROUP 5");

        System.out.println(
                "==============================================");

        while (running) {

            showMenu();

            int choice =
                    readInt("เลือกเมนู: ");

            System.out.println();

            switch (choice) {

                case 1:
                    addAction();
                    break;

                case 2:
                    undoAction();
                    break;

                case 3:
                    redoAction();
                    break;

                case 4:
                    resetSystem();
                    break;

                case 5:
                    changeAlgorithm();
                    break;

                case 6:
                    testingMenu();
                    break;

                case 0:

                    running = false;

                    System.out.println(
                            "ออกจากโปรแกรมเรียบร้อย");

                    break;

                default:

                    System.out.println(
                            "กรุณาเลือกเมนู 0 - 6");
            }

            if (running) {
                showStatus();
            }
        }

        scanner.close();
    }

    // =====================================================
    // MAIN MENU
    // =====================================================

    private static void showMenu() {

        System.out.println();

        System.out.println(
                "==============================================");

        System.out.println(
                "              EMERGENCY WORKFLOW");

        System.out.println(
                "==============================================");

        System.out.println(
                "Algorithm : "
                        + algorithm.getName());

        System.out.println(
                "Current State : "
                        + algorithm.getCurrentState());

        System.out.println(
                "----------------------------------------------");

        System.out.println(
                "1. เพิ่ม Action");

        System.out.println(
                "2. Undo");

        System.out.println(
                "3. Redo");

        System.out.println(
                "4. Reset");

        System.out.println(
                "5. เปลี่ยน Algorithm");

        System.out.println(
                "6. ทดสอบและวิเคราะห์");

        System.out.println(
                "0. ออกจากโปรแกรม");

        System.out.println(
                "==============================================");
    }

    // =====================================================
    // 1. ADD ACTION
    // =====================================================

    private static void addAction() {

        System.out.println(
                "==============================================");

        System.out.println(
                "                 เพิ่ม Action");

        System.out.println(
                "==============================================");

        System.out.println(
                "1. CALL_RECEIVED");

        System.out.println(
                "2. TEAM_ASSIGNED");

        System.out.println(
                "3. VEHICLE_DISPATCHED");

        System.out.println(
                "4. ARRIVED_AT_SCENE");

        System.out.println(
                "5. CASE_CLOSED");

        System.out.println(
                "0. ยกเลิก");

        int choice =
                readInt("เลือก Action: ");

        if (choice == 0) {
            return;
        }

        Action action =
                convertAction(choice);

        if (action == null) {

            System.out.println(
                    "Action ไม่ถูกต้อง");

            return;
        }

        boolean success =
                algorithm.addAction(action);

        if (success) {

            System.out.println(
                    "เพิ่ม Action สำเร็จ: "
                            + action);

        } else {

            System.out.println(
                    "เพิ่ม Action ไม่สำเร็จ");

            System.out.println(
                    "ห้าม Transition ผิดลำดับ");
        }
    }

    // =====================================================
    // 2. UNDO
    // =====================================================

    private static void undoAction() {

        if (algorithm.undo()) {

            System.out.println(
                    "UNDO สำเร็จ");

        } else {

            System.out.println(
                    "UNDO ไม่สำเร็จ "
                            + "(Event Stack ว่าง)");
        }
    }

    // =====================================================
    // 3. REDO
    // =====================================================

    private static void redoAction() {

        if (algorithm.redo()) {

            System.out.println(
                    "REDO สำเร็จ");

        } else {

            System.out.println(
                    "REDO ไม่สำเร็จ "
                            + "(Redo Stack ว่าง "
                            + "หรือ Transition ผิด)");
        }
    }

    // =====================================================
    // 4. RESET
    // =====================================================

    private static void resetSystem() {

        algorithm.reset();

        System.out.println(
                "Reset สำเร็จ");

        System.out.println(
                "Event Stack = ว่าง");

        System.out.println(
                "Redo Stack = ว่าง");

        System.out.println(
                "Current State = NEW");
    }

    // =====================================================
    // 5. CHANGE ALGORITHM
    // =====================================================

    private static void changeAlgorithm() {

        System.out.println(
                "==============================================");

        System.out.println(
                "              เปลี่ยน Algorithm");

        System.out.println(
                "==============================================");

        System.out.println(
                "1. Algorithm A - Event Stack");

        System.out.println(
                "2. Algorithm B - Event Stack + State Machine");

        System.out.println(
                "0. ยกเลิก");

        int choice =
                readInt("เลือก Algorithm: ");

        switch (choice) {

            case 1:

                algorithm =
                        new Event_Stack();

                System.out.println(
                        "เปลี่ยนเป็น Algorithm A");

                System.out.println(
                        "ระบบ Reset อัตโนมัติ");

                break;

            case 2:

                algorithm =
                        new State_Machine();

                System.out.println(
                        "เปลี่ยนเป็น Algorithm B");

                System.out.println(
                        "ระบบ Reset อัตโนมัติ");

                break;

            case 0:
                break;

            default:

                System.out.println(
                        "เลือกไม่ถูกต้อง");
        }
    }

    // =====================================================
    // 6. TESTING MENU
    // =====================================================

    private static void testingMenu() {

        boolean back = false;

        while (!back) {

            System.out.println();

            System.out.println(
                    "==============================================");

            System.out.println(
                    "              TEST & ANALYSIS");

            System.out.println(
                    "==============================================");

            System.out.println(
                    "1. Test Cases 10 ข้อ");

            System.out.println(
                    "2. แสดง Operation Count");

            System.out.println(
                    "3. Performance Test");

            System.out.println(
                    "0. กลับ");

            int choice =
                    readInt("เลือก: ");

            switch (choice) {

                case 1:
                    runAllTests();
                    break;

                case 2:
                    showOperationCount();
                    break;

                case 3:
                    runPerformanceTest();
                    break;

                case 0:
                    back = true;
                    break;

                default:
                    System.out.println(
                            "เลือกไม่ถูกต้อง");
            }
        }
    }

    // =====================================================
    // OPERATION COUNT
    // =====================================================

    private static void showOperationCount() {

        System.out.println();

        System.out.println(
                "Algorithm : "
                        + algorithm.getName());

        System.out.println(
                "Push : "
                        + algorithm.getPushCount());

        System.out.println(
                "Pop : "
                        + algorithm.getPopCount());

        System.out.println(
                "Comparisons : "
                        + algorithm.getComparisonCount());

        System.out.println(
                "Loops : "
                        + algorithm.getLoopCount());

        System.out.println(
                "Moved Data : "
                        + algorithm.getMovedDataCount());
    }

    // =====================================================
    // TEST CASES 1-10
    // =====================================================

    private static void runAllTests() {

        runTestsFor(
                new Event_Stack());

        System.out.println();

        runTestsFor(
                new State_Machine());
    }

    private static void runTestsFor(
            WorkflowAlgorithm a) {

        int passed = 0;

        System.out.println();
        System.out.println(
                "========== "
                        + a.getName()
                        + " ==========");

        // Test 1
        a.reset();

        boolean test1 =
                addFullWorkflow(a)
                &&
                a.getCurrentState()
                        == State.CLOSED;

        passed += printTest(1, test1);

        // Test 2
        a.reset();

        boolean test2 =
                !a.addAction(
                        Action.TEAM_ASSIGNED)
                &&
                a.getCurrentState()
                        == State.NEW;

        passed += printTest(2, test2);

        // Test 3
        a.reset();

        boolean test3 =
                !a.addAction(
                        Action.CASE_CLOSED)
                &&
                a.getCurrentState()
                        == State.NEW;

        passed += printTest(3, test3);

        // Test 4
        a.reset();

        a.addAction(
                Action.CALL_RECEIVED);

        a.addAction(
                Action.TEAM_ASSIGNED);

        boolean test4 =
                a.undo()
                &&
                a.getCurrentState()
                        == State.RECEIVED
                &&
                a.getData()
                        .getRedoStack()
                        .size()
                        == 1;

        passed += printTest(4, test4);

        // Test 5
        a.reset();

        a.addAction(
                Action.CALL_RECEIVED);

        a.addAction(
                Action.TEAM_ASSIGNED);

        a.addAction(
                Action.VEHICLE_DISPATCHED);

        a.undo();
        a.undo();

        boolean test5 =
                a.getData()
                        .getRedoStack()
                        .size()
                        == 2
                &&
                a.getCurrentState()
                        == State.RECEIVED;

        passed += printTest(5, test5);

        // Test 6
        boolean test6 =
                a.redo()
                &&
                a.getData()
                        .getRedoStack()
                        .size()
                        == 1
                &&
                a.getCurrentState()
                        == State.ASSIGNED;

        passed += printTest(6, test6);

        // Test 7
        boolean test7 =
                a.addAction(
                        Action.VEHICLE_DISPATCHED)
                &&
                a.getData()
                        .getRedoStack()
                        .isEmpty()
                &&
                a.getCurrentState()
                        == State.DISPATCHED;

        passed += printTest(7, test7);

        // Test 8
        a.reset();

        a.addAction(
                Action.CALL_RECEIVED);

        boolean firstUndo =
                a.undo();

        boolean secondUndo =
                a.undo();

        boolean test8 =
                firstUndo
                &&
                !secondUndo
                &&
                a.getData()
                        .getEventStack()
                        .isEmpty()
                &&
                a.getCurrentState()
                        == State.NEW;

        passed += printTest(8, test8);

        // Test 9
        a.reset();

        boolean test9 =
                !a.redo()
                &&
                a.getCurrentState()
                        == State.NEW;

        passed += printTest(9, test9);

        // Test 10
        a.reset();

        addFullWorkflow(a);

        boolean test10 =
                !a.addAction(
                        Action.CALL_RECEIVED)
                &&
                a.getCurrentState()
                        == State.CLOSED;

        passed += printTest(10, test10);

        System.out.println(
                "--------------------------------");

        System.out.println(
                "ผลรวม: "
                        + passed
                        + "/10 PASS");
    }

    private static boolean addFullWorkflow(
            WorkflowAlgorithm a) {

        return a.addAction(
                    Action.CALL_RECEIVED)

                &&
                a.addAction(
                    Action.TEAM_ASSIGNED)

                &&
                a.addAction(
                    Action.VEHICLE_DISPATCHED)

                &&
                a.addAction(
                    Action.ARRIVED_AT_SCENE)

                &&
                a.addAction(
                    Action.CASE_CLOSED);
    }

    private static int printTest(
            int number,
            boolean result) {

        System.out.println(
                "Test "
                        + number
                        + " : "
                        + (result
                        ? "PASS"
                        : "FAIL"));

        return result ? 1 : 0;
    }

    // =====================================================
    // PERFORMANCE TEST
    // =====================================================

    private static void runPerformanceTest() {

        int[] sizes = {
                100,
                1000,
                10000,
                50000
        };

        int rounds = 5;

        System.out.println();

        System.out.println(
                "==============================================================");

        System.out.println(
                "                 PERFORMANCE TEST");

        System.out.println(
                "==============================================================");

        System.out.println(
                "แต่ละ n ทดสอบ "
                        + rounds
                        + " รอบ");

        System.out.println();

        System.out.printf(
                "%-8s %-32s %-18s %-10s %-10s %-15s %-10s%n",
                "n",
                "Algorithm",
                "Average Time(ns)",
                "Push",
                "Pop",
                "Comparisons",
                "Loops");

        System.out.println(
                "------------------------------------------------------------------------------------------------");

        for (int n : sizes) {

            runBenchmark(
                    new Event_Stack(),
                    n,
                    rounds);

            runBenchmark(
                    new State_Machine(),
                    n,
                    rounds);
        }
    }

    // =====================================================
    // BENCHMARK
    // =====================================================

    private static void runBenchmark(
            WorkflowAlgorithm a,
            int n,
            int rounds) {

        long totalTime = 0;

        long totalPush = 0;
        long totalPop = 0;
        long totalComparison = 0;
        long totalLoop = 0;

        /*
         * Warm-up
         */
        for (int i = 0; i < 2; i++) {

            benchmarkExecute(a, n);

            a.reset();
        }

        /*
         * ทดสอบจริง 5 รอบ
         */
        for (int round = 0;
             round < rounds;
             round++) {

            a.reset();

            long startTime =
                    System.nanoTime();

            benchmarkExecute(
                    a,
                    n);

            long endTime =
                    System.nanoTime();

            totalTime +=
                    endTime - startTime;

            totalPush +=
                    a.getPushCount();

            totalPop +=
                    a.getPopCount();

            totalComparison +=
                    a.getComparisonCount();

            totalLoop +=
                    a.getLoopCount();
        }

        long averageTime =
                totalTime / rounds;

        long averagePush =
                totalPush / rounds;

        long averagePop =
                totalPop / rounds;

        long averageComparison =
                totalComparison / rounds;

        long averageLoop =
                totalLoop / rounds;

        System.out.printf(
                "%-8d %-32s %-18d %-10d %-10d %-15d %-10d%n",
                n,
                a.getName(),
                averageTime,
                averagePush,
                averagePop,
                averageComparison,
                averageLoop);
    }

    // =====================================================
    // BENCHMARK EXECUTION
    // =====================================================

    private static void benchmarkExecute(
            WorkflowAlgorithm a,
            int n) {

        /*
         * สร้างข้อมูลจำลอง n รายการ
         * เพื่อวัดการทำงานของ Algorithm
         *
         * ใช้ Action ที่วนซ้ำเพื่อให้สามารถ
         * สร้างข้อมูลจำนวนมากได้
         */

        for (int i = 0;
             i < n;
             i++) {

            /*
             * ทุก 5 รายการคือ workflow
             * หนึ่งรอบ
             */

            int type = i % 5;

            switch (type) {

                case 0:

                    a.addAction(
                            Action.CALL_RECEIVED);

                    break;

                case 1:

                    a.addAction(
                            Action.TEAM_ASSIGNED);

                    break;

                case 2:

                    a.addAction(
                            Action.VEHICLE_DISPATCHED);

                    break;

                case 3:

                    a.addAction(
                            Action.ARRIVED_AT_SCENE);

                    break;

                case 4:

                    a.addAction(
                            Action.CASE_CLOSED);

                    /*
                     * เริ่ม workflow ใหม่
                     * เพื่อให้สามารถทดสอบ n
                     * จำนวนมากได้
                     */

                    a.reset();

                    break;
            }
        }
    }

    // =====================================================
    // STATUS
    // =====================================================

    private static void showStatus() {

        WorkflowData data =
                algorithm.getData();

        System.out.println();

        System.out.println(
                "--------------- STATUS ----------------");

        System.out.println(
                "Algorithm : "
                        + algorithm.getName());

        System.out.println(
                "Current State : "
                        + data.getCurrentState());

        showEventStack(data);

        showRedoStack(data);

        System.out.println(
                "----------------------------------------");
    }

    // =====================================================
    // EVENT STACK
    // =====================================================

    private static void showEventStack(
            WorkflowData data) {

        List<Action> list =
                data.eventBottomToTop();

        System.out.println();

        System.out.println(
                "Event Stack:");

        System.out.println(
                "TOP");

        if (list.isEmpty()) {

            System.out.println(
                    "  [ว่าง]");

        } else {

            for (int i = list.size() - 1;
                 i >= 0;
                 i--) {

                System.out.println(
                        "  "
                                + list.get(i));
            }
        }

        System.out.println(
                "BOTTOM");
    }

    // =====================================================
    // REDO STACK
    // =====================================================

    private static void showRedoStack(
            WorkflowData data) {

        List<Action> list =
                data.redoTopToBottom();

        System.out.println();

        System.out.println(
                "Redo Stack:");

        System.out.println(
                "TOP");

        if (list.isEmpty()) {

            System.out.println(
                    "  [ว่าง]");

        } else {

            for (Action action : list) {

                System.out.println(
                        "  "
                                + action);
            }
        }

        System.out.println(
                "BOTTOM");
    }

    // =====================================================
    // ACTION CONVERTER
    // =====================================================

    private static Action convertAction(
            int choice) {

        switch (choice) {

            case 1:
                return Action.CALL_RECEIVED;

            case 2:
                return Action.TEAM_ASSIGNED;

            case 3:
                return Action.VEHICLE_DISPATCHED;

            case 4:
                return Action.ARRIVED_AT_SCENE;

            case 5:
                return Action.CASE_CLOSED;

            default:
                return null;
        }
    }

    // =====================================================
    // INPUT
    // =====================================================

    private static int readInt(
            String message) {

        while (true) {

            System.out.print(message);

            String input =
                    scanner.nextLine().trim();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "กรุณาป้อนตัวเลขเท่านั้น");
            }
        }
    }
}