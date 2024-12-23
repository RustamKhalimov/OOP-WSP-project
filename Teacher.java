class Teacher extends User {
    private String department;

    public Teacher(String name, String department) {
        super(name);
        this.department = department;
    }

    @Override
    public int getMaxBorrowDuration() {
        return 360;
    }

	@Override
	protected String getName() {
		return name;
	}
	
	 @Override
	    public String toString() {
	        return name + " (Преподаватель, Кафедра: " + department + ")";
	    }
}