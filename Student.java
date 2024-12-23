class Student extends User {
    private String referral;

    public Student(String name, String referral) {
        super(name);
        this.referral = referral;
    }

    @Override
    public int getMaxBorrowDuration() {
        return 180;
    }

    @Override
	protected String getName() {
		return name;
	}
    
    @Override
    public String toString() {
        return name + " (Студент, Группа: " + referral + ")";
    }

}