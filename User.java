abstract class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    public abstract int getMaxBorrowDuration();

    @Override
    public String toString() {
        return name;
    }

	protected abstract String getName();
}