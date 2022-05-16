import java.util.Arrays;

public class StudentHoang {
    public static void main(String[] args) {
        StudentArchive studentArchive = new StudentArchive();
        Iterator iterator = studentArchive.getIterator("LexicalOrder");
        while (iterator.hasNext()) {
            if ("Hoang".equals(iterator.next())) {
                System.out.println("Hoang is in the name");
            } else {
                System.out.println("Not found");
            }
        }
        System.out.println();
        Iterator iterator2 = studentArchive.getIterator("Normal");
        while (iterator2.hasNext()) {
            if ("Hoang".equals(iterator2.next())) {
                System.out.println("Hoang is in the name");
            } else {
                System.out.println("Not found");
            }
        }

    }
}

interface Container {
    public Iterator getIterator(String type);
}

interface Iterator {
    public boolean hasNext();

    public Object next();
}

class StudentArchive implements Container {
    private String[] names = { "Hanh", "An", "Nam", "Hoang", "Tam", "Triet", "Binh" };

    // iterator factory
    public Iterator getIterator(String type) {
        if (type.equals("Normal")) {
            return new StudentIterator();
        } else if (type.equals("LexicalOrder")) {
            return new LexicalOrderIterator();
        } else {
            return null;
        }
    }

    private class StudentIterator implements Iterator {
        int index;

        StudentIterator() {
            index = 0;
        }

        public boolean hasNext() {
            if (names != null) {
                if (index >= names.length) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }

        public Object next() {
            return names[index++];
        }
    }

    private class LexicalOrderIterator implements Iterator {
        int index;
        String[] lexicalOrderNames;

        LexicalOrderIterator() {
            if (names != null) {
                lexicalOrderNames = names.clone();
                Arrays.sort(lexicalOrderNames);
            }
            index = 0;
        }

        public boolean hasNext() {
            if (lexicalOrderNames != null) {
                if (index >= lexicalOrderNames.length) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }

        public Object next() {
            return lexicalOrderNames[index++];
        }
    }
}