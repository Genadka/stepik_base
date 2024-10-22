package block_five.serialize;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Alice", 30);
        User user2 = new User("Bob", 25);

        String userFilename = "user.ser";
        Serializer.serialize(user1, userFilename);

        User deserializedUser = (User) Deserializer.deserialize(userFilename);
        System.out.println(deserializedUser);

        User[] userArray = {user1, user2};
        UserList userList = new UserList(userArray);

        String userListFilename = "userList.ser";
        Serializer.serialize(userList, userListFilename);

        UserList deserializedUserList = (UserList) Deserializer.deserialize(userListFilename);
        for (User user : deserializedUserList.getUsers()) {
            System.out.println(user);
        }
    }
}