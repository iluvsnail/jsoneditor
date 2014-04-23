package cn.edu.sdu.qlsc.yh.test;

public interface IPersonDao {
	public Person select(String id);
	public void insert(Person student);

}
