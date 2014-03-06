local function map_flight(record)
	return map {record.CARRIER, record.FL_NUM. record.FL_DATE, record.DEP_TIME, "cats"}
end


function time(stream, start, stop)
    local function filter_period(record)
    	info("in period")
    	return (record.DEP_TIME >= start and record.DEP_TIME <= stop)
    end
	info("in time")
    return stream :  filter(filter_period) : map(map_flight)
    
end