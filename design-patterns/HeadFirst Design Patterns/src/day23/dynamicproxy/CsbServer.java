package day23.dynamicproxy;

import java.util.List;

public interface CsbServer {
	@Request(value="GET", url="http://www.naver.com")
	public List<VirtualMachine> getAvailableVirtualMachines();
}
