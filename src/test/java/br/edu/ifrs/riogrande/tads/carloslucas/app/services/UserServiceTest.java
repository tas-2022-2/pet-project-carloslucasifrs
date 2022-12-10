package br.edu.ifrs.riogrande.tads.carloslucas.app.services;

import org.junit.jupiter.api.BeforeEach;

public class UserServiceTest {
    UserService userServiceStub;

    @BeforeEach
    void init() {
        userServiceStub = new UserServiceStub();
    }

    static class UserServiceStub implements UserService {
.
        @Override
        public List<Produto> reservaProdutos(List<Integer> codigos)
                throws ProdutoNaoEncontradoException, ProdutoSemEstoqueException {
            if (codigos.contains(111)) {
                throw new ProdutoNaoEncontradoException(111);
            }
            if (codigos.contains(222)) {
                throw new ProdutoSemEstoqueException(222);
            }
            List<Produto> produtos = new ArrayList<>();
            for (Integer codigo : codigos) {
                produtos.add(new Produto(codigo, "Produto " + codigo, 10));
            }
            return produtos;
        }

        @Override
        public void liberarProdutos(List<Integer> codigos) {
            // TODO Auto-generated method stub

        }

        @Override
        public void confirmaProdutos(List<Integer> codigos) {
            // TODO Auto-generated method stub

        }
    }
}
