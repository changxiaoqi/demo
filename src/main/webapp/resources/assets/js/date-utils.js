/**
 * 获取某一个月的最后一天
 * @param year 年
 * @param month 月
 * @returns {number} 最后一天
 */
function getLastDay(year, month) {
    var new_year = year;    //取当前的年份
    var new_month = month++;//取下一个月的第一天，方便计算（最后一天不固定）
    if (month > 12) {
        new_month -= 12;        //月份减
        new_year++;            //年份增
    }
    var new_date = new Date(new_year, new_month, 1);                //取当年当月中的第一天
    return (new Date(new_date.getTime() - 1000 * 60 * 60 * 24)).getDate();//获取当月最后一天日期
}

/**
 * 获取某年某月的第一天时间
 * @param year
 * @param month
 * @returns {Date}
 */
function getStartDate(year, month) {
    var dateStr = year + '-' + month + '-01 00:00:00';
    return new Date(dateStr);
}

/**
 * 获取某年某月最后一天的时间
 * @param year
 * @param month
 * @returns {Date}
 */
function getEndDate(year, month) {
    var lastDay = getLastDay(year, month);
    var dateStr = year + '-' + month + '-' + lastDay + ' 23:59:59';
    return new Date(dateStr)
}

/**
 * 获取两个日期的月份差
 * @param start
 * @param end
 */
function getMonths(start, end) {
    var startMonth = parseInt(start.getMonth());
    var endMonth = parseInt(end.getMonth());
    var startYear = parseInt(start.getFullYear());
    var endYear = parseInt(end.getFullYear());
    if (endYear == startYear)
        return endMonth - startMonth;
    return (endYear - startYear) * 12 + (endMonth - startMonth);
}


/**
 * 由秒数转换成时间
 * 如:3700-> 1:01:40
 * @param seconds
 */
function scondsToTime(seconds) {
    var str;
    //对小时取余
    var hour = parseInt(seconds / 3600);
    seconds = seconds - hour * 3600;
    //对分钟取余
    var minute = parseInt(seconds / 60);
    seconds = seconds - minute * 60;
    str = (hour < 10 ? ('0'+hour+":") : (hour + ':')) + ' ' + (minute < 10 ? '0' + minute : minute) + ' :' + (seconds < 10 ? '0' + seconds : seconds);
    return str;
}