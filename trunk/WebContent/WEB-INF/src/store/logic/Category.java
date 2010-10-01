package store.logic;

public class Category 
{
	private Integer id;
	private String  name;
	private Integer depth;
	private Integer parent;
	private Integer thread;
	private Integer order;
	
	public Category()
	{
		this.id = new Integer(0);
		this.depth = new Integer(0);
		this.parent = new Integer(0);
		this.thread = new Integer(0);
		this.order = new Integer(0);
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getDepth() {
		return depth;
	}
	
	public void setDepth(Integer depth) {
		this.depth = depth;
	}
	
	public Integer getParent() {
		return parent;
	}
	
	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public Integer getThread() {
		return thread;
	}

	public void setThread(Integer thread) {
		this.thread = thread;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}
}
