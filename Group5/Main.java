package Group5;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner =
            new Scanner(System.in);

    /*
     * โปรแกรมหลักใช้ Algorithm B
     * Event Stack + State Machine
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

                case 0:

                    running = false;

                    System.out.println(
                            "ออกจากโปรแกรมเรียบร้อย");

                    break;

                default:

                    System.out.println(
                            "กรุณาเลือกเมนู 0 - 4");
            }

            if (running) {
                showStatus();
            }

            System.out.println();
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
                "                 MAIN MENU");

        System.out.println(
                "==============================================");

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
                "0. ออกจากโปรแกรม");

        System.out.println(
                "==============================================");
    }

    // =====================================================
    // 1. เพิ่ม ACTION
    // =====================================================

    private static void addAction() {

        System.out.println(
                "==============================================");

        System.out.println(
                "                 เพิ่ม Action");

        System.out.println(
                "==============================================");

        System.out.println(
                "Current State : "
                        + algorithm.getCurrentState());

        System.out.println();

        System.out.println(
                "เลือก Action ที่ต้องการเพิ่ม");

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

        System.out.println();

        int choice =
                readInt("เลือก Action: ");

        if (choice == 0) {

            System.out.println(
                    "ยกเลิกการเพิ่ม Action");

            return;
        }

        Action action =
                convertAction(choice);

        if (action == null) {

            System.out.println(
                    "เลือก Action ไม่ถูกต้อง");

            return;
        }

        System.out.println();

        System.out.println(
                "Action ที่เลือก : "
                        + action);

        /*
         * เพิ่ม Action เข้า Workflow ทันที
         */
        boolean success =
                algorithm.addAction(action);

        if (success) {

            System.out.println();

            System.out.println(
                    "เพิ่ม Action สำเร็จ");

            System.out.println(
                    "Action : "
                            + action);

            System.out.println(
                    "Current State ใหม่ : "
                            + algorithm.getCurrentState());

            /*
             * กฎข้อ 3:
             *
             * ถ้าเพิ่ม Action ใหม่หลัง Redo
             * Redo Stack ต้องถูกล้าง
             *
             * การล้าง Redo ทำอยู่ใน
             * algorithm.addAction()
             */

        } else {

            System.out.println();

            System.out.println(
                    "ไม่สามารถเพิ่ม Action ได้");

            System.out.println(
                    "สาเหตุ: Transition ผิดลำดับ");

            System.out.println(
                    "Event Stack และ Redo Stack "
                            + "จะไม่ถูกเปลี่ยน");
        }
    }

    // =====================================================
    // 2. UNDO
    // =====================================================

    private static void undoAction() {

        System.out.println(
                "==============================================");

        System.out.println(
                "                    UNDO");

        System.out.println(
                "==============================================");

        boolean success =
                algorithm.undo();

        if (success) {

            System.out.println(
                    "UNDO สำเร็จ");

            System.out.println(
                    "Action ล่าสุดถูกย้ายจาก "
                            + "Event Stack → Redo Stack");

        } else {

            System.out.println(
                    "UNDO ไม่สำเร็จ");

            System.out.println(
                    "Event Stack ไม่มี Action");
        }
    }

    // =====================================================
    // 3. REDO
    // =====================================================

    private static void redoAction() {

        System.out.println(
                "==============================================");

        System.out.println(
                "                    REDO");

        System.out.println(
                "==============================================");

        boolean success =
                algorithm.redo();

        if (success) {

            System.out.println(
                    "REDO สำเร็จ");

            System.out.println(
                    "Action ล่าสุดถูกย้ายจาก "
                            + "Redo Stack → Event Stack");

        } else {

            System.out.println(
                    "REDO ไม่สำเร็จ");

            System.out.println(
                    "Redo Stack ไม่มี Action "
                            + "หรือ Transition ไม่ถูกต้อง");
        }
    }

    // =====================================================
    // 4. RESET
    // =====================================================

    private static void resetSystem() {

        algorithm.reset();

        System.out.println(
                "==============================================");

        System.out.println(
                "                   RESET");

        System.out.println(
                "==============================================");

        System.out.println(
                "Event Stack ถูกล้าง");

        System.out.println(
                "Redo Stack ถูกล้าง");

        System.out.println(
                "Current State = NEW");
    }

    // =====================================================
    // แปลงหมายเลขเป็น ACTION
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
    // แสดงสถานะ
    // =====================================================

    private static void showStatus() {

        WorkflowData data =
                algorithm.getData();

        System.out.println();

        System.out.println(
                "==============================================");

        System.out.println(
                "                  STATUS");

        System.out.println(
                "==============================================");

        System.out.println(
                "Current State : "
                        + data.getCurrentState());

        System.out.println();

        showEventStack(data);

        System.out.println();

        showRedoStack(data);

        System.out.println(
                "==============================================");
    }

    // =====================================================
    // EVENT STACK
    // =====================================================

    private static void showEventStack(
            WorkflowData data) {

        List<Action> events =
                data.eventBottomToTop();

        System.out.println(
                "Event Stack:");

        System.out.println(
                "TOP");

        if (events.isEmpty()) {

            System.out.println(
                    "  [ว่าง]");

        } else {

            for (int i = events.size() - 1;
                 i >= 0;
                 i--) {

                System.out.println(
                        "  "
                                + events.get(i));
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

        List<Action> redo =
                data.redoTopToBottom();

        System.out.println(
                "Redo Stack:");

        System.out.println(
                "TOP");

        if (redo.isEmpty()) {

            System.out.println(
                    "  [ว่าง]");

        } else {

            for (Action action : redo) {

                System.out.println(
                        "  "
                                + action);
            }
        }

        System.out.println(
                "BOTTOM");
    }

    // =====================================================
    // รับตัวเลข
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