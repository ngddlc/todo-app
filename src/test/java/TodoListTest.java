import org.example.TodoList;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoListTest {
    @Test
    void addAndList() {
        TodoList t = new TodoList();
        t.add(" task1 ");
        assertEquals(1, t.size());
        assertEquals("task1", t.getAll().getFirst());
    }

    @Test
    void remove() {
        TodoList t = new TodoList();
        t.add("a");
        t.add("b");
        assertTrue(t.remove(0));
        assertEquals(1, t.size());
        assertFalse(t.remove(10));
    }

    @Test
    void addEmptyIgnored() {
        TodoList t = new TodoList();
        t.add(" ");
        assertEquals(0, t.size());
    }

    @Test
    void clear() {
        TodoList t = new TodoList();
        t.add("item 1");
        t.add("item 2");
        assertEquals(2, t.size());
        t.clear();
        assertEquals(0, t.size());
    }

    @Test
    void markDone() {
        TodoList t = new TodoList();
        t.add("buy milk");
        assertTrue(t.markDone(0));
        assertEquals("[DONE] buy milk", t.getAll().getFirst());
        assertFalse(t.markDone(5));
    }

    @Test
    void search() {
        TodoList t = new TodoList();
        t.add("buy milk");
        t.add("buy bread");
        t.add("clean room");
        List<String> results = t.search("buy");
        assertEquals(2, results.size());
        assertEquals("buy milk", results.get(0));
        assertEquals("buy bread", results.get(1));
    }
}
