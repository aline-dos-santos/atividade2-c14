cd Exercicio1_c14
sudo apt-get install mailutils
echo "Pipeline executado!" | mail -s "Pipeline" "$DEST_EMAIL"