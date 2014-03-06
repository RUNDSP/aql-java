local function my_record_udf(record)
  info("Hello %s", "Bob")
  
  
  
  
end

function call_go(r, a_number)
	local power = require("power")
	local r = power.go(a_number);
	info(r)
	return r
end