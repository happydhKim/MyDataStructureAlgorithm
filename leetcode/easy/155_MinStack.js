/**
 * initialize your data structure here.
 */
var MinStack = function() {
  this.stack = [];
};

/** 
 * @param {number} val
 * @return {void}
 */
MinStack.prototype.push = function(val) {
	const min = this.stack.length === 0 ? val : this.stack[this.stack.length - 1].min;
	this.stack.push({val, min: Math.min(min, val)});
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
	if(this.stack.length > 0) {
		this.stack.pop();
	}
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
	if(this.stack.length > 0) {
		return this.stack[this.stack.length - 1].val;
	}
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
  if(this.stack.length > 0) {
		return this.stack[this.stack.length - 1].min;
	}
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */


 var obj = new MinStack();
 obj.push(5);
 obj.push(3);
 obj.push(2);
 obj.push(-3);
 obj.push(10);
 obj.push(12);
 obj.pop();
 var param_3 = obj.top();
 var param_4 = obj.getMin();
 console.log(obj);
