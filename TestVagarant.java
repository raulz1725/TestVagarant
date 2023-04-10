import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class RecentlyPlayedStore {
    private int capacity;
    private Map<String, Queue<String>> userSongsMap;

    public RecentlyPlayedStore(int capacity) {
        this.capacity = capacity;
        this.userSongsMap = new HashMap<>();
    }

    public void addSongForUser(String user, String song) {
        if (!userSongsMap.containsKey(user)) {
            userSongsMap.put(user, new LinkedList<>());
        }
        Queue<String> songsQueue = userSongsMap.get(user);
        if (songsQueue.size() >= capacity) {
            songsQueue.poll();
        }
        songsQueue.offer(song);
    }

    public Queue<String> getRecentlyPlayedSongsForUser(String user) {
        return userSongsMap.get(user);
    }

    public static void main(String[] args) {
        int initialCapacity = 3;
        RecentlyPlayedStore store = new RecentlyPlayedStore(initialCapacity);

        String user = "Rahul";
        store.addSongForUser(user, "S1");
        store.addSongForUser(user, "S2");
        store.addSongForUser(user, "S3");
        System.out.println(store.getRecentlyPlayedSongsForUser(user));

        store.addSongForUser(user, "S4");
        System.out.println(store.getRecentlyPlayedSongsForUser(user));

        store.addSongForUser(user, "S2");
        System.out.println(store.getRecentlyPlayedSongsForUser(user));

        store.addSongForUser(user, "S1");
        System.out.println(store.getRecentlyPlayedSongsForUser(user));
    }
}
