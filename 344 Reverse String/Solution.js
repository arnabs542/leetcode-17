/**
 * @param {string} s
 * @return {string}
 */
var reverseString = function(s) {
	var sReverse = "";
	for (var i = s.length - 1; i >= 0; i--) {
		sReverse += s[i];
	}
	return sReverse;
};