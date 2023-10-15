package edu.hw2;

import javax.swing.text.Utilities;

public class Task3 {
    public interface Connection extends AutoCloseable {
        void execute(String command);
    }

    public interface ConnectionManager {
        Connection getConnection();
    }

    public final class PopularCommandExecutor {
        //private final ConnectionManager manager;
        //private final int maxAttempts;

        public void updatePackages() {
        //    tryExecute("apt update && apt upgrade -y");
        }

     //   void tryExecute(String command) { ...}
    }

    public static void main(String[] args) throws ConnectionException {

    }
}
