package ao;

import java.util.List;
import java.util.Map;

public interface AO<T> {
	public List<T> fetchAll();
	public List<T> search(Map<String,Object> criteria);
	public boolean update(T t);
	public boolean delete(T t);
}
