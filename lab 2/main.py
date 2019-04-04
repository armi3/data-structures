import djikstras

graph = djikstras.Graph()

edges = [
    ('USD', 'CNY', 6.71),
    ('EUR', 'USD', 1.12),
    ('Q', 'USD', 0.13),
    ('Q', 'VES', 4.28),
    ('EUR', 'VES', 3694.16),
    ('ARS', 'MXN', 0.44),
    ('ZWD', 'MXN', 0.052),
    ('CHF', 'MXN', 19.61),
    ('CHF', 'USD', 0.99),
]

for edge in edges:
    graph.add_edge(*edge)

print(djikstras.dijsktra(graph, 'USD', 'MXN'))
