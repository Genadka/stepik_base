package block_five.serialize;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Alice", 30);
        User user2 = new User("Bob", 25);

        String userFilename = "user.ser";
        UserSerializer.serializeUser(user1, userFilename);

        User deserializedUser = UserDeserializer.deserializeUser(userFilename);
        System.out.println(deserializedUser);

        User[] userArray = {user1, user2};
        UserList userList = new UserList(userArray);

        String userListFilename = "userList.ser";
        UserListSerializer.serializeUserList(userList, userListFilename);

        UserList deserializedUserList = UserListDeserializer.deserializeUserList(userListFilename);
        for (User user : deserializedUserList.getUsers()) {
            System.out.println(user);
        }
    }
}
