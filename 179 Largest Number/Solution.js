/**
 * @param {number[]} nums
 * @return {string}
 */
var largestNumber = function(nums) {
	var numsSort = nums.sort(compare);
	return trimResultString(numsSort.join(""));
};

// return true is sA >= sB
var compare = function (sA, sB) {
	sA = String(sA);
	sB = String(sB);
	return parseInt(sA + sB) >= parseInt(sB + sA) ? -1 : 1;
};

var trimResultString = function (sInput) {
	sInput = String(sInput);
	var sRe = sInput;
	if (sInput && sInput[0] === '0') {
		for (var i = 0; i <= sInput.length - 2; i++) {
			if (sInput[i] === '0') {
				sRe = sInput.substring(i + 1);
			} else {
				return sRe;
			}
		}
	}
	return sRe;
};