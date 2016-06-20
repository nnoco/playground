package day7;

public interface RequestInfo {
	@Request(url="http://www.donga.ac.kr/studentinfo", method="GET")
	public int requestName();
	
	@Request(url="http://softwareinlife.com/csbio/api/vm", method="POST")
	public int postVirtualMachine();
}
