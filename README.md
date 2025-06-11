DOCUMENTAÇÃO DO BACKEND
SISTEMA DE HIERARQUIA ORGANIZACIONAL

Introdução
Este documento descreve o sistema de gerenciamento de organizações, times e grupos, um protótipo projetado para estruturar, organizar e conectar usuários dentro de um ambiente colaborativo. O sistema permite a criação e gestão hierárquica de organizações, a formação de times focados em objetivos específicos e a criação de grupos para fomentar a comunicação e colaboração em torno de interesses comuns.
Através de um sistema robusto de associações (memberships) e controle de permissões, a plataforma visa otimizar a comunicação, facilitar a colaboração e gerenciar o acesso a diferentes níveis de estrutura e interação. Os papéis de "Admin", "Manager" e "Member" definem as capacidades e responsabilidades dos usuários dentro do sistema, garantindo um ambiente organizado e seguro.
Este documento detalha as funcionalidades do sistema através de User Stories, representando as necessidades e expectativas dos diferentes usuários, e estabelece as regras de negócio que governam o comportamento e as restrições das entidades chave: Organizações, Times, Grupos e Associações (Memberships). O objetivo é fornecer uma compreensão clara da arquitetura e das funcionalidades do sistema para fins de desenvolvimento, implementação e utilização.




Entidades
Organization
Teams
Groups
Admin
Manager
Member
Membership

User Stories: Admin

Como Admin, gostaria de criar uma organização para que eu possa estruturar e gerenciar diferentes departamentos ou entidades dentro do sistema.
Como Admin, gostaria de criar um time para que eu possa agrupar usuários com responsabilidades específicas dentro de uma organização.
Como Admin, gostaria de criar um grupo para que eu possa reunir usuários com interesses ou projetos em comum para facilitar a comunicação e colaboração.
Como Admin, gostaria de adicionar membros para que eu possa incluir usuários em organizações, times e grupos, permitindo que eles participem das atividades.
Como Admin, gostaria de remover uma organização para que eu possa desativar ou excluir estruturas organizacionais que não são mais necessárias.
Como Admin, gostaria de remover um time para que eu possa desfazer agrupamentos de usuários quando um time não for mais relevante.
Como Admin, gostaria de remover um grupo para que eu possa encerrar a participação de um conjunto de usuários em um tópico ou projeto específico.
Como Admin, gostaria de remover membros para que eu possa retirar usuários de organizações, times e grupos quando necessário.
Como Admin, gostaria de desfazer associações entre usuários para que eu possa corrigir ou remover relações de pertencimento incorretas entre usuários e organizações, times ou grupos.
Como Admin, gostaria de ver uma organização para que eu possa acessar os detalhes e informações de uma estrutura organizacional.
Como Admin, gostaria de ver um time para que eu possa visualizar os membros e detalhes de um time específico.
Como Admin, gostaria de ver um grupo para que eu possa verificar os participantes e informações de um grupo.
Como Admin, gostaria de ver membros para que eu possa acessar a lista de todos os usuários cadastrados no sistema.
Como Admin, gostaria de ver as associações de membros para que eu possa entender a quais organizações, times e grupos um usuário pertence.
Como Admin, gostaria de ver todos os Gerentes de uma Equipe para que eu possa identificar rapidamente os responsáveis pela gestão dentro de um time.
Como Admin, gostaria de ver todos os Membros de uma Equipe para que eu possa ter uma visão completa da composição de um time.
Como Admin, gostaria de ver todos os Membros para que eu possa ter uma visão geral de todos os usuários no sistema.
Como Admin, gostaria de atualizar uma organização para que eu possa modificar informações como nome, descrição ou configurações de uma organização.
Como Admin, gostaria de atualizar um time para que eu possa alterar o nome, descrição ou membros de um time.
Como Admin, gostaria de atualizar um grupo para que eu possa modificar o nome, descrição ou participantes de um grupo.
Como Admin, gostaria de atualizar o papel dos membros para que eu possa alterar as permissões e responsabilidades de um usuário dentro de uma organização, time ou grupo.
Como Admin, gostaria de realizar associações entre usuários para que eu possa vincular usuários a organizações, times e grupos.
Como Admin, gostaria de atribuir o papel de Gerente a alguém para que eu possa designar um usuário como responsável pela gestão de um time.
Como Admin, gostaria de tornar alguém membro de uma Equipe para que eu possa adicionar um usuário específico a um time.
Como Admin, gostaria de atribuir o papel de Membro a alguém para que eu possa definir o papel padrão de um usuário dentro de uma organização, time ou grupo.


User Stories: Manager

Como Manager, gostaria de criar um time para que eu possa organizar e gerenciar os membros da minha equipe de forma eficaz.
Como Manager, gostaria de criar um grupo para que eu possa reunir membros com interesses ou tarefas específicas para facilitar a colaboração.
Como Manager, gostaria de adicionar membros para que eu possa incluir novos usuários na minha equipe ou nos grupos que gerencio.
Como Manager, gostaria de remover um time do qual sou o gerente para que eu possa desativar ou excluir equipes que não são mais necessárias sob minha gestão.
Como Manager, gostaria de remover um grupo para que eu possa encerrar a participação de um conjunto de usuários em um tópico ou projeto específico que eu gerencio.
Como Manager, gostaria de remover membros para que eu possa retirar usuários da minha equipe ou dos grupos que gerencio quando necessário.
Como Manager, gostaria de ver uma organização para que eu possa entender a estrutura organizacional na qual minha equipe está inserida.
Como Manager, gostaria de ver um time para que eu possa visualizar os detalhes e membros de outras equipes.
Como Manager, gostaria de ver um grupo para que eu possa verificar os participantes e informações de outros grupos.
Como Manager, gostaria de ver membros para que eu possa acessar a lista de todos os usuários cadastrados no sistema.
Como Manager, gostaria de ver as associações de membros para que eu possa entender a quais organizações, times e grupos um usuário pertence.
Como Manager, gostaria de ver todos os Gerentes de uma Equipe para que eu possa identificar rapidamente os responsáveis pela gestão dentro de outras equipes.
Como Manager, gostaria de ver todos os membros de uma Equipe para que eu possa ter uma visão completa da composição de outras equipes.
Como Manager, gostaria de ver todos os Membros para que eu possa ter uma visão geral de todos os usuários no sistema.
Como Manager, gostaria de atualizar um time para que eu possa modificar o nome, descrição ou membros da minha equipe.
Como Manager, gostaria de atualizar um grupo para que eu possa modificar o nome, descrição ou participantes dos grupos que gerencio.
Como Manager, gostaria de atualizar o papel dos membros para que eu possa alterar as permissões e responsabilidades dos membros da minha equipe ou dos grupos que gerencio.
Como Manager, gostaria de realizar associações entre usuários para que eu possa vincular usuários à minha equipe ou aos grupos que gerencio.
Como Manager, gostaria de tornar alguém membro de uma Equipe para que eu possa adicionar um usuário específico à minha equipe.
Como Manager, gostaria de atribuir o papel de Membro a alguém para que eu possa definir o papel padrão de um usuário dentro da minha equipe ou dos grupos que gerencio.

Regras de Negócios: Admin

RNE001 - Criação de Estruturas: Um Admin pode criar qualquer número de organizações, times e grupos dentro do sistema.
RNE002 - Adição de Membros: Um Admin pode adicionar qualquer usuário existente no sistema a qualquer organização, time ou grupo.
RNE003 - Remoção de Estruturas: Um Admin pode remover qualquer organização, time ou grupo existente no sistema, independentemente de quem o criou ou dos membros que o compõem. A remoção de uma organização pode ter implicações para os times e grupos dentro dela (a serem definidas - ex: remoção em cascata ou orfandade).
RNE004 - Remoção de Membros: Um Admin pode remover qualquer membro de qualquer organização, time ou grupo.
RNE005 - Desfazer Associações: Um Admin tem a capacidade de desfazer qualquer relação de pertencimento entre usuários e organizações, times ou grupos.
RNE006 - Visibilidade Total: Um Admin tem visibilidade de todas as organizações, times, grupos e membros do sistema, incluindo seus relacionamentos e papéis.
RNE007 - Atualização de Estruturas: Um Admin pode modificar os detalhes (nome, descrição, configurações) de qualquer organização, time ou grupo.
RNE008 - Gerenciamento de Papéis: Um Admin pode alterar o papel de qualquer membro dentro de qualquer contexto (organização, time, grupo).
RNE009a - Atribuição de Papel de Manager: A atribuição do papel de "Manager" a um usuário só pode ser realizada por um Admin.
RNE009b - Atribuição de Papel de Member: A atribuição do papel de "Member" a um usuário só pode ser realizada por um Admin.
RNE009c - Designação de Staff: A designação de membros para um "Staff" só pode ser realizada por um Admin.

Regras de Negócio: Manager
RNE001 - Criação Limitada de Times: Um Manager pode criar novos times dentro do sistema.
RNE002 - Criação Limitada de Grupos: Um Manager pode criar novos grupos dentro do sistema.
RNE003 - Adição de Membros em Estruturas Gerenciadas: Um Manager pode adicionar usuários existentes no sistema aos times e grupos que ele gerencia.
RNE004 - Remoção de Times Gerenciados: Um Manager só pode remover times dos quais ele é o gerente.
RNE005 - Remoção de Grupos Gerenciados: Um Manager pode remover os grupos que ele gerencia.
RNE006 - Remoção de Membros em Estruturas Gerenciadas: Um Manager pode remover membros dos times e grupos que ele gerencia.
RNE007 - Visibilidade Abrangente: Um Manager pode ver todas as organizações, times, grupos e membros do sistema.
RNE008 - Atualização de Times Gerenciados: Um Manager pode modificar os detalhes (nome, descrição, membros) dos times que ele gerencia.
RNE009 - Atualização de Grupos Gerenciados: Um Manager pode modificar os detalhes (nome, descrição, participantes) dos grupos que ele gerencia.
RNE010 - Gerenciamento de Papéis em Estruturas Gerenciadas: Um Manager pode atualizar o papel dos membros dentro dos times e grupos que ele gerencia.
RNE011 - Associação de Membros em Estruturas Gerenciadas: Um Manager pode associar usuários aos times e grupos que ele gerencia.
RNE012 - Designação de Staff em Times Gerenciados: Um Manager pode designar membros como "Staff" dentro dos times que ele gerencia.
RNE013 - Atribuição de Papel de Membro em Estruturas Gerenciadas: Um Manager pode atribuir o papel de "Member" a usuários dentro dos times e grupos que ele gerencia.

Regras de Negócio: Member

RNE001 - Visibilidade da Organização: Um Member pode visualizar a organização à qual pertence.
RNE002 - Visibilidade do Próprio Time: Um Member pode visualizar o time do qual é membro e identificar o gerente desse time.
RNE003 - Visibilidade do Próprio Grupo: Um Member pode visualizar o grupo do qual é membro e identificar os outros membros desse grupo.
RNE004 - Visibilidade de Membros do Próprio Grupo: Um Member pode visualizar a lista de todos os membros do grupo ao qual pertence.
RNE005 - Visibilidade de Gerentes do Próprio Time: Um Member pode visualizar a lista de todos os gerentes do time ao qual pertence.
RNE006 - Visibilidade de Membros do Grupo Participado: Um Member pode visualizar a lista de todos os membros de qualquer grupo do qual ele faça parte.
RNE007 - Restrição de Criação: Um Member não tem permissão para criar organizações, times ou grupos.
RNE008 - Restrição de Remoção: Um Member não tem permissão para remover organizações, times ou grupos, nem membros de qualquer estrutura.
RNE009 - Restrição de Atualização: Um Member não tem permissão para atualizar informações de organizações, times ou grupos.
RNE010 - Restrição de Gerenciamento de Papéis: Um Member não tem permissão para alterar o papel de outros usuários.
RNE011 - Restrição de Associação: Um Member não tem permissão para associar outros usuários a organizações, times ou grupos.

Regras de Negócio: Membership

RNE001: Cada associação deve vincular um único usuário a uma única organização, time ou grupo.
RNE002: A criação de uma associação pode ser iniciada pelo usuário (solicitação), por um administrador ou manager (convite ou adição direta), ou automaticamente pelo sistema.
RNE003: Uma associação pode ter um papel específico atribuído ao membro dentro daquela organização, time ou grupo.
RNE004: A data e hora de início de uma associação devem ser registradas automaticamente pelo sistema.
RNE005: Se definida, a data e hora de fim de uma associação devem ser respeitadas pelo sistema, revogando o acesso automaticamente.
RNE006: A remoção de uma associação deve ser registrada com a data e hora da remoção e, opcionalmente, o motivo.
RNE007: Tentativas de criar associações duplicadas para o mesmo usuário na mesma entidade (organização, time, grupo) devem ser bloqueadas.
RNE008: A aprovação de uma solicitação de associação pode ser necessária dependendo das configurações da organização, time ou grupo e do papel do solicitante.
RNE009: A revogação de uma associação pode ser realizada por administradores ou managers da respectiva organização, time ou grupo.
RNE010: O sistema deve garantir a integridade referencial entre as tabelas de usuários e as tabelas de organizações, times e grupos ao gerenciar associações.
RNE011: A consulta das associações de um usuário deve ser restrita ao próprio usuário e a administradores. A consulta das associações de uma organização, time ou grupo deve ser restrita a administradores e managers da respectiva entidade.
RNE012: A alteração do papel de um membro dentro de uma associação deve ser restrita a administradores ou managers da respectiva organização, time ou grupo.
RNE013: Se um limite máximo de membros for definido para um time ou grupo, novas associações não devem ser permitidas após atingir o limite.
RNE014: O sistema pode gerar alertas ou relatórios sobre associações pendentes, associações com prazos próximos ao vencimento ou associações inativas.
RNE015: A transferência de propriedade de uma entidade (time ou grupo) pode envolver a alteração do papel de um membro na associação.


