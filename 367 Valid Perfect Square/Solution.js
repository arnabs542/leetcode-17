/**
 * @param {number} num
 * @return {boolean}
 */
var isPerfectSquare = function(num) {
	if (num < 0) {
		return false;
	} else {
		return findSquareRoot(0, num, num);
	}
};

// use binary search to find the root of the square within the range given
var findSquareRoot = function (left, right, num) {
	debugger;
	var mid = parseInt((left + right) / 2);

	if (left <= right) {
		if (getSquare(mid) === num) {
			return true;
		} else if (getSquare(mid) < num){
			return findSquareRoot(mid + 1, right, num);
		} else {
			// getSquare(mid) > num
			return findSquareRoot(left, mid - 1, num);
		}
	} else {
		return false;
	}
}

var getSquare = function (num) {
	return num * num;
};