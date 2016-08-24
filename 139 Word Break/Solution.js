/**
 * @param {string} s
 * @param {set<string>} wordDict
 *   Note: wordDict is a Set object, see:
 *   https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Set
 * @return {boolean}
 */

//reference: http://fisherlei.blogspot.ca/2013/11/leetcode-word-break-solution.html

var wordBreak = function (s, wordDict) {
	s = "#" + s;
	var aWorkBreak = [];

	aWorkBreak[0] = true;
	for (var i = 1; i <= s.length; i ++) {
		for (var j = 0; j <= i; j ++) {
			if (aWorkBreak[j] && wordDict.has(s.slice(j + 1, i + 1))) {
				aWorkBreak[i] = true;
				break;
			}
		}
	}
	return s.length > 0 ? !!aWorkBreak[s.length] : false;
};

var wordBreak_1 = function(s, wordDict) {
	if (typeof s  === "string" && s.length > 0) {
		var aWordDict = [];
		wordDict.forEach(w => aWordDict.push(w));
		return aWordDict.some(function (element) {
			if (s.indexOf(element) >= 0) {
				var iStartIndex = s.indexOf(element);
				var iEndIndex = iStartIndex + element.length;
				var sStart = s.slice(0, iStartIndex);
				var sEnd = s.slice(iEndIndex);
				return wordBreak(sStart, wordDict) && wordBreak(sEnd, wordDict);
			} else {
				return false;
			}
		});
	} else if (typeof s  === "string" && s.length === 0) {
		return true;
	} else {
		return false;
	}
};