USE pdv;

SELECT * FROM cliente;
SELECT * FROM venda;
SELECT * FROM produto;

SELECT * FROM localidade;
SELECT * FROM desconto;

Select * from cliente  Where codcli = 4 AND 670.5 < 745;

SELECT p.descricao, v.Qte_venda, p.preco_unitario, v.valor_total  
From Venda v 
JOIN Produto p ON p.Codprod = v.Codprod 
JOIN cliente c ON c.CodCli = v.codcli 
WHERE c.codCli = 4 AND p.codprod = 10;

SELECT valor_total, qte_venda, codlocal FROM venda WHERE codcli = 1 AND codlocal = 3 AND data_venda = '2019-10-21'