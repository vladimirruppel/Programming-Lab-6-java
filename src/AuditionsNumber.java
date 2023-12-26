public class AuditionsNumber {
    int count = 0;

    int getCount() {
        return count;
    }

    void setCount(int count) throws IllegalArgumentException {
        if (count < 0) {
            throw new IllegalArgumentException("Negative Auditions Number");
        }
        this.count = count;
    }

    int addCount(int plusCount) {
        count += plusCount;
        return count;
    }
}
