package edu.hw2.third;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    void updatePackages() throws Exception {
        tryExecute("apt update && apt upgrade -y");
    }

    private void tryExecute(String command) throws Exception {
        for (int i = 0; i < maxAttempts; i++) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                break;
            } catch (ConnectionException e) {
                if (i == maxAttempts - 1) {
                    throw new ConnectionException("Failed to execute the command after " + maxAttempts + " attempts.");
                }
            }
        }
    }
}

