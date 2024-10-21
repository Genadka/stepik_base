package bloc_four;

public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);

    @Override
    void close();

    interface RobotConnectionManager {
        RobotConnection getConnection();
    }

    class RobotController {
        public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
            int attempts = 0;
            RobotConnection connection = null;
            while (attempts < 3) {
                try {
                    connection = robotConnectionManager.getConnection();
                    connection.moveRobotTo(toX, toY);
                    return;
                } catch (RobotConnectionException e) {
                    attempts++;
                    if (attempts >= 3) {
                        throw e;
                    }
                } catch (Exception e) {
                    throw e;
                } finally {
                    if (connection != null) {
                        try {
                            connection.close();
                        } catch (Exception ignored) {
                        }
                    }
                }
            }
        }
    }

    class RobotConnectionException extends RuntimeException {
        public RobotConnectionException(String message) {
            super(message);
        }

        public RobotConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    class Main {
        public static void main(String[] args) {
            RobotConnectionManager manager = new RobotConnectionManager() {
                @Override
                public RobotConnection getConnection() {
                    return new RobotConnection() {
                        @Override
                        public void moveRobotTo(int x, int y) {
                            System.out.println("Moving robot to coordinates: (" + x + ", " + y + ")");
                        }

                        @Override
                        public void close() {
                            System.out.println("Closing connection");
                        }
                    };
                }
            };

            try {
                RobotController.moveRobot(manager, 5, 10);
            } catch (RobotConnectionException e) {
                System.out.println("Failed to move robot after 3 attempts: " + e.getMessage());
            }
        }
    }
}