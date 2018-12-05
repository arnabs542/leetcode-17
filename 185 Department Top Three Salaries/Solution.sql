# Write your MySQL query statement below
SELECT D.Name AS Department, E.Name AS Employee, Salary
FROM Employee E
INNER JOIN Department D ON E.DepartmentId = D.Id
WHERE
(SELECT COUNT(DISTINCT(E1.Salary)) FROM Employee E1 WHERE E.Salary <= E1.Salary AND E.DepartmentId = E1.DepartmentId) <= 3
ORDER BY DepartmentId ASC, Salary DESC