kubectl delete -f ../deployment.yaml
kubectl delete -f ../postgres/postgres-deployment.yaml
kubectl delete -f ../postgres/postgres-storage.yaml
kubectl delete -f ../postgres/postgres-configmap.yaml
kubectl apply -f ../postgres/postgres-configmap.yaml
kubectl apply -f ../postgres/postgres-storage.yaml
kubectl apply -f ../postgres/postgres-deployment.yaml
kubectl apply -f ../deployment.yaml

